//Trail of ones
//Given a number n, find the number of binary strings of length n that contain consecutive 1's in them.
// Since the number can be very large, return the answer after modulo with 1e9+7.

//Example 1:
//Input: n = 2
//Output: 1
//Explanation: There are 4 strings of length 2, the strings are 00, 01, 10, and 11. Only the string 11 has consecutive 1's.

public class NumberOfConsecutiveOnes {
    static int numberOfConsecutiveOnes(int n) {
        // code here
        if (n == 2)
            return 1;
        int result = 1;
        int a = 0;
        int b = 1;
        int mod = 1000000007;

        for (int i = 3; i <= n; i++) {
            int c = (a + b) % mod;
            a = b;
            b = c;
            result = ((result * 2) % mod + c) % mod;
        }
        return result;
    }
}
