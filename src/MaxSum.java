//Max sum in the configuration
//Given an integer array(0-based indexing) a of size n.
// Your task is to return the maximum value of the sum of i*a[i] for all 0<= i <=n-1,
// where a[i] is the element at index i in the array.
// The only operation allowed is to rotate(clockwise or counterclockwise) the array any number of times.

//Example 1:
//Input: n = 4, a[] = {8, 3, 1, 2}
//Output: 29
//Explanation: All the configurations possible by rotating the elements are:
//3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
//1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
//2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
//8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11, so the maximum sum will be 29.

public class MaxSum {
    long max_sum(int a[], int n) {
        // Your code here
        long sum = 0;
        long prev = 0;
        for(int i=0; i<n; i++){
            prev += ((long)a[i]*(long)i);
            sum += a[i];
        }
        long res = prev;
        for(int i=1; i<n; i++){
            long curr = prev-(sum-a[i-1]) + (long)a[i-1]*(n-1);
            if(curr > res){
                res = curr;
            }
            prev = curr;
        }
        return res;
    }
}
