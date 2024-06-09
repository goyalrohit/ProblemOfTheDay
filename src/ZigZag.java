//Convert array into Zig-Zag fashion
//Given an array arr of distinct elements of size n,
// the task is to rearrange the elements of the array in a zig-zag fashion
// so that the converted array should be in the below form:
//arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n].
//Note: Modify the given arr[] only, If your transformation is correct, the output will be 1 else the output will be 0.

//Examples
//Input: n = 7, arr[] = {4, 3, 7, 8, 6, 2, 1}
//Output: 3 7 4 8 2 6 1
//Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1

public class ZigZag {

    public static void zigZag(int n, int[] arr) {
        // code here
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            else{
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        // print arr
        System.out.print("Output: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        zigZag(n, arr);
    }
}
