//Summed Matrix
//A matrix is constructed of size n*n and given an integer ‘q’. The value at every cell of the matrix is given as, M(i,j) = i+j, where ‘M(i,j)' is the value of a cell, ‘i’ is the row number, and ‘j’ is the column number. Return the number of cells having value ‘q’.
//Note: Assume, the array is in 1-based indexing.

//Examples:
//Input: n = 4, q = 7
//Output: 2
//Explanation: Matrix becomes
//2 3 4 5
//3 4 5 6
//4 5 6 7
//5 6 7 8
//The count of 7 is 2.

public class SummedMatrix {
    static long sumMatrix(long n, long q) {
        // code here
        long count = 0;
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= n; j++) {
                if (i + j == q) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long n = 4, q = 7;
        System.out.println(sumMatrix(n, q));
    }
}
