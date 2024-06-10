//Given a set of n nuts & bolts. There is a one-on-one mapping between nuts and bolts.
// You have to Match nuts and bolts efficiently. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means the nut can only be compared with the bolt and the bolt can only be compared with the nut to see which one is bigger/smaller.
//The elements should follow the following order: { !,#,$,%,&,*,?,@,^ }
//Note: Make all the required changes directly in the given arrays, output will be handled by the driver code.
//Examples
//Input: n = 5, nuts[] = {@, %, $, #, ^}, bolts[] = {%, @, #, $ ^}
//Output:
        //# $ % @ ^
        //# $ % @ ^
//Explanation: As per the order # should come first after that $ then % then @ and ^.

import java.util.Arrays;

public class MatchPairs {

    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        Arrays.sort(nuts);
        Arrays.sort(bolts);
        System.out.println(nuts);
        System.out.println(bolts);
        return;
    }

    public static void main(String[] args) {
        MatchPairs matchPairs = new MatchPairs();
        matchPairs.matchPairs(5, new char[]{'@', '#', '$', '%', '^'}, new char[]{'%', '@', '#', '$', '^'});
        matchPairs.matchPairs(5, new char[]{'^', '#', '$', '%', '@'}, new char[]{'%', '@', '#', '$', '^'});
    }
}
