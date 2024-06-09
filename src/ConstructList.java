//Construct list using given q XOR queries
//Given a list s that initially contains only a single value 0. There will be q queries of the following types:
//0 x: Insert x in the list
//1 x: For every element a in s, replace it with a ^ x. ('^' denotes the bitwise XOR operator)
//Return the sorted list after performing the given q queries.

//Example 1:
//Input: q = 5, queries[] = {{0, 6}, {0, 3}, {0, 2}, {1, 4}, {1, 5}}
//Output: 1 2 3 7
//Explanation:[0] (initial value)
//[0 6] (add 6 to list)
//[0 6 3] (add 3 to list)
//[0 6 3 2] (add 2 to list)
//[4 2 7 6] (XOR each element by 4)
//[1 7 2 3] (XOR each element by 5)
//The sorted list after performing all the queries is [1 2 3 7].

import java.util.*;

public class ConstructList {

    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        int x = 0;
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = q - 1; i >= 0; i--) {
            if (queries[i][0] == 1) x ^= queries[i][1];
            else intList.add(queries[i][1] ^ x);
        }
        intList.add(x);
        Collections.sort(intList);
        return intList;
    }

    public static void main(String[] args) {
        ConstructList constructList = new ConstructList();
        System.out.println(constructList.constructList(5, new int[][]{{0, 6}, {0, 3}, {0, 2}, {1, 4}, {1, 5}}));
    }
}
