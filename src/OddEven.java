//Odd Even Problem
//Given a string s of lowercase English characters, determine whether the summation of x and y is EVEN or ODD.where:
//x is the count of distinct characters that occupy even positions in the English alphabet and have even frequency.
//y is the count of distinct characters that occupy odd positions in the English alphabet and have odd frequency.
//Ex: string = "ab" here 'a' has an odd(1) position in the English alphabet & has an odd(1) frequency in the string so a is odd but b has an even(2) position in the English alphabet & has odd(1) frequency so it doesn't count(since string doesn't have 2 b's) so the final answer x + y = 1+0 = 1(odd) would be "ODD".
//Note: Return "EVEN" if the sum of x & y is even otherwise return "ODD".

//Example 1:
//Input: s = "abbbcc"
//Output: ODD
//Explanation: x = 0 and y = 1 so (x + y) is ODD. 'a' occupies 1st place(odd) in english alphabets and its frequency is odd(1),
// 'b' occupies 2nd place(even) but its frequency is odd(3) so it doesn't get counted and
// 'c' occupies 3rd place(odd) but its frequency is even(2) so it also doesn't get counted.

public class OddEven {

    public static String oddEven(String s) {
        // code here
        String result = "";
        // Array to store character frequencies
        int[] characterCnt = new int[26];

        // Calculate character frequencies
        for (char chr : s.toCharArray()) {
            if (Character.isLetter(chr)) {
                int index = chr - 'a';
                characterCnt[index]++;
            }
        }
        int x = 0; // Count of distinct characters with even position and even frequency
        int y = 0; // Count of distinct characters with odd position and odd frequency

        for (int i = 0; i < 26; i++) {
            if (characterCnt[i] > 0) {
                if ((i + 1) % 2 == 0) { // Even position
                    if (characterCnt[i] % 2 == 0) { // Even frequency
                        x++;
                    }
                } else { // Odd position
                    if (characterCnt[i] % 2 != 0) { // Odd frequency
                        y++;
                    }
                }
            }
        }
        result = (x + y) % 2 == 0 ? "EVEN" : "ODD";
        return result;
    }
}
