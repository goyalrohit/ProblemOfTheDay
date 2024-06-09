//Swapping pairs make sum equal
//Given two arrays of integers a[] and b[] of size n and m, the task is to check if a pair of values
// (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.
//Note: Return 1 if there exists any such pair otherwise return -1.
//Example 1:
//Input: n = 6, m = 4, a[] = {4, 1, 2, 1, 1, 2}, b[] = (3, 6, 3, 3)
//Output: 1
//Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15, To get same sum from both arrays, we can swap following values: 1 from a[] and 3 from b[]

import java.util.*;

public class FindSwapValues {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < n || i < m; i++) {
            if (i < n)
                sum1 += a[i];

            if (i < m)
                sum2 += b[i];
        }
        int j = 0;
        long k = 0;

        if (sum1 > sum2) {
            j = n;
            Arrays.sort(b);
        } else {
            j = m;
            Arrays.sort(a);
        }
        for (int i = 0; i < j; i++) {
            if (sum1 > sum2) {
                while (i < n - 1 && a[i] == a[i + 1]) {
                    i++;
                }
                if ((sum1 - sum2 - 2 * a[i]) % 2 == 0) {
                    k = -1 * (sum1 - sum2 - 2 * a[i]) / 2;
                    if (search(b, k)) {
                        return 1;
                    }
                } else {
                    i++;
                }
            } else {
                while (i < m - 1 && b[i] == b[i + 1]) {
                    i++;
                }
                if ((sum2 - sum1 - 2 * b[i]) % 2 == 0) {
                    k = -1 * (sum2 - sum1 - 2 * b[i]) / 2;
                    if (search(a, k)) {
                        return 1;
                    }
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    boolean search(long[] arr, long k) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == k) {
                return true;
            } else if (arr[mid] > k) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindSwapValues findSwapValues = new FindSwapValues();
        System.out.println(findSwapValues.findSwapValues(new long[]{4, 1, 2, 1, 1, 2}, 6, new long[]{3, 6, 3, 3}, 4));
    }
}
