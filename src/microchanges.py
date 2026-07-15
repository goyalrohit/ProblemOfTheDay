import git
import ast
import difflib
from typing import List, Tuple

class MicroChange:
    def __init__(self, change_type: str, old_code: str, new_code: str):
        self.change_type = change_type
        self.old_code = old_code
        self.new_code = new_code

class CodeChangeAnalyzer:
    def __init__(self, repo_path: str):
        self.repo = git.Repo(repo_path)

    def get_latest_commit_diff(self) -> str:
        return self.repo.git.diff('HEAD~1..HEAD')

    def parse_diff(self, diff: str) -> List[Tuple[str, str, str]]:
        lines = diff.split('\n')
        changes = []
        current_file = ''
        old_lines = []
        new_lines = []

        for line in lines:
            if line.startswith('diff --git'):
                if current_file:
                    changes.append((current_file, ''.join(old_lines), ''.join(new_lines)))
                current_file = line.split()[-1][2:]
                old_lines = []
                new_lines = []
            elif line.startswith('-') and not line.startswith('---'):
                old_lines.append(line[1:] + '\n')
            elif line.startswith('+') and not line.startswith('+++'):
                new_lines.append(line[1:] + '\n')

        if current_file:
            changes.append((current_file, ''.join(old_lines), ''.join(new_lines)))

        return changes

    def identify_micro_changes(self, old_code: str, new_code: str) -> List[MicroChange]:
        old_ast = ast.parse(old_code)
        new_ast = ast.parse(new_code)

        old_nodes = list(ast.walk(old_ast))
        new_nodes = list(ast.walk(new_ast))

        micro_changes = []

        for old_node, new_node in zip(old_nodes, new_nodes):
            if not isinstance(old_node, type(new_node)):
                micro_changes.append(MicroChange('node_type_change', ast.unparse(old_node), ast.unparse(new_node)))
            elif isinstance(old_node, ast.FunctionDef):
                if old_node.name != new_node.name:
                    micro_changes.append(MicroChange('function_rename', old_node.name, new_node.name))
            elif isinstance(old_node, ast.Assign):
                old_target = old_node.targets[0].id if isinstance(old_node.targets[0], ast.Name) else ''
                new_target = new_node.targets[0].id if isinstance(new_node.targets[0], ast.Name) else ''
                if old_target != new_target:
                    micro_changes.append(MicroChange('variable_rename', old_target, new_target))

        return micro_changes

    def generate_description(self, micro_changes: List[MicroChange]) -> str:
        descriptions = []
        for change in micro_changes:
            if change.change_type == 'node_type_change':
                descriptions.append(f"Changed '{change.old_code}' to '{change.new_code}'")
            elif change.change_type == 'function_rename':
                descriptions.append(f"Renamed function from '{change.old_code}' to '{change.new_code}'")
            elif change.change_type == 'variable_rename':
                descriptions.append(f"Renamed variable from '{change.old_code}' to '{change.new_code}'")

        return "\n".join(descriptions)

    def analyze_latest_commit(self) -> str:
        diff = self.get_latest_commit_diff()
        changes = self.parse_diff(diff)
        all_descriptions = []

        for file_path, old_code, new_code in changes:
            micro_changes = self.identify_micro_changes(old_code, new_code)
            description = self.generate_description(micro_changes)
            all_descriptions.append(f"Changes in {file_path}:\n{description}")

        return "\n\n".join(all_descriptions)

# Usage
if __name__ == "__main__":
    analyzer = CodeChangeAnalyzer('C:/Users/Rohit/IdeaProjects/DSA/ProblemOfTheDay')
    change_description = analyzer.analyze_latest_commit()
    print(change_description)
