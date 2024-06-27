//Toeplitz matrix
//A Toeplitz (or diagonal-constant) matrix is a matrix in which each descending diagonal from left to right is constant, i.e., all elements in a diagonal are the same. Given a rectangular matrix mat, your task is to complete the function isToeplitz which returns 1 if the matrix is Toeplitz otherwise, it returns 0.
//Examples:
/*
Input:
mat = [[6, 7, 8],
        [4, 6, 7],
        [1, 4, 6]]
Output: 1
Explanation: The test case represents a 3x3 matrix
 6 7 8
         4 6 7
         1 4 6
Output: 1(True) as values in all downward diagonals from left to right contain the same elements.
Expected time complexity: O(n*m)
Expected space complexity: O(1)
*/


public class ToeplitzMatrix {

    boolean isToepliz(int mat[][]) {
        // Your code here
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] mat = {{6, 7, 8}, {4, 6, 7}, {1, 4, 6}};
        ToeplitzMatrix obj = new ToeplitzMatrix();
        int result = obj.isToepliz(mat) ? 1 : 0;
        System.out.println(result);
    }

}
