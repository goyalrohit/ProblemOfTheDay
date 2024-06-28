//The Palindrome Pattern
//Given a two-dimensional integer array arr of dimensions n x n, consisting solely of zeros and ones, identify the row or column (using 0-based indexing) where all elements form a palindrome. If multiple palindromes are identified, prioritize the palindromes found in rows over those in columns. Within rows or columns, the palindrome with the smaller index takes precedence. The result should be represented by the index followed by either 'R' or 'C', indicating whether the palindrome was located in a row or column. The output should be space-separated. If no palindrome is found, return the string -1.
/*Examples:

Input:
arr[][] =  [[1, 0, 0],
        [0, 1, 0],
        [1, 1, 0]]
Output: 1 R
Explanation: In the first test case, 0-1-0 is a palindrome
occuring in a row having index 1.*/

public class PalindromePattern {
    public String pattern(int[][] arr) {
        // Code here
        // for all rows
        for(int i = 0; i < arr.length; i++){
            if(isRowPalindrome(arr[i])){
                return i + " " + "R";
            }
        }

        // for all cols
        for(int j = 0; j < arr[0].length; j++){
            if(isColPalindrome(arr, j)){
                return j + " " + "C";
            }
        }

        return "-1";
    }

    boolean isRowPalindrome(int row[]){

        int left = 0, right = row.length - 1;

        while(left <= right){
            if(row[left] != row[right]){
                return false;
            }
            left++; right--;
        }

        return true;
    }

    boolean isColPalindrome(int arr[][], int j){

        int left = 0, right = arr.length - 1;

        while(left <= right){
            if(arr[left][j] != arr[right][j]){
                return false;
            }
            left++; right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePattern  palindromePattern = new PalindromePattern();
        int[][] arr = {{1, 0, 0},
                {0, 1, 0},
                {1, 1, 0}};
        System.out.println(palindromePattern.pattern(arr));
    }
}
