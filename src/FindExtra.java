//Index of an Extra Element
//You have given two sorted arrays arr1[] & arr2[] of distinct elements.
//The first array has one element extra added in between. Return the index of the extra element.
//Example
//Input: n = 7, arr1[] = {2,4,6,8,9,10,12}, arr2[] = {2,4,6,8,10,12}
//Output: 4

public class FindExtra {

    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        for (int i = 0; i < n -1 ; i++) {
            if (arr2[i] != arr1[i]) {
                return i;
            }
        }
        return n -1;
    }

    public static void main(String[] args) {
        FindExtra findExtra = new FindExtra();
        System.out.println(findExtra.findExtra(7, new int[]{2, 4, 6, 8, 9, 10, 12}, new int[]{2, 4, 6, 8, 10, 12}));
    }
}

