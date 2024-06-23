//Print Bracket Number
//Given a string str, the task is to find the bracket numbers, i.e., for each bracket in str, return i if the bracket is the ith opening or closing bracket to appear in the string.

//Examples:
//Input:  str = "(aa(bdc))p(dee)"
//Output: 1 2 2 1 3 3
//Explanation: The highlighted brackets in the given string (aa(bdc))p(dee) are assigned the numbers as: 1 2 2 1 3 3.


import java.util.ArrayList;
import java.util.Stack;

public class BracketNumbers {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        ArrayList<Integer> bracketNumber = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                count += 1;
                stack.push(count);
                bracketNumber.add(count);
            }
            else if (str.charAt(i) == ')'){
                bracketNumber.add(stack.pop());
            }

        }

        return bracketNumber;
    }

    public static void main(String[] args) {
        BracketNumbers bracketNumbers = new BracketNumbers();
        System.out.println(bracketNumbers.bracketNumbers("(aa(bdc))p(dee)"));
    }
}
