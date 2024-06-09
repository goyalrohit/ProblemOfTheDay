//Maximum occured integer
//Given n integer ranges, the task is to return the maximum occurring integer in the given ranges.
// If more than one such integer exists, return the smallest one.
//The ranges are in two arrays l[] and r[].
// l[i] consists of the starting point of the range and
// r[i] consists of the corresponding endpoint of the range & a maxx which is the maximum value of r[].

//For example, consider the following ranges.
//l[] = {2, 1, 3}, r[] = {5, 3, 9)
//Ranges represented by the above arrays are.
//[2, 5] = {2, 3, 4, 5}
//[1, 3] = {1, 2, 3}
//[3, 9] = {3, 4, 5, 6, 7, 8, 9}
//The maximum occurred integer in these ranges is 3.

//Examples :
//Input: n = 4, l[] = {1,4,3,1}, r[] = {15,8,5,4}, maxx = 15
//Output: 4
//Explanation: The given ranges are [1,15] [4, 8] [3, 5] [1, 4]. The smallest number that is most common or appears most times in the ranges is 4.


public class MaxOccured {
    public static int maxOccured(int n, int l[], int r[], int maxx) {

        // Step 1: Initialize the frequency array
        int[] freq = new int[maxx + 1];
        // Step 2: Update the frequency array
        for (int i = 0; i < n; i++) {
            for (int j = l[i]; j <= r[i]; j++) {
                freq[j]++;
            }
        }
        // Step 3: Find the maximum frequency
        int maxFreq = 0;
        for (int i = 0; i <= maxx; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }
        // Step 4: Find the smallest integer with the maximum frequency
        int result = -1;
        for (int i = 0; i <= maxx; i++) {
            if (freq[i] == maxFreq) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxOccured maxOccured = new MaxOccured();
        int n = 4;
        int[] l = {1, 4, 3, 1};
        int[] r = {15, 8, 5, 4};
        int maxx = 15;
        System.out.println(maxOccured.maxOccured(n, l, r, maxx));
    }
}
