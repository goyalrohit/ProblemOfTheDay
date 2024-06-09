//Binary representation of next number
//Given a binary representation in the form of a string(s) of a number n, the task is to find a binary representation of n+1.
//Note: Output binary string should not contain leading zeros.

//Example 1:
//Input: s = "10"
//Output: 11
//Explanation: "10" is the binary representation of 2 and binary representation of 3 is "11"

public class BinaryNextNumber {
    String binaryNextNumber(String s) {
        // code here.
        boolean indication = true;
        char[] temp = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (temp[i] == '0') {
                temp[i] = '1';
                indication = false;
                break;
            } else temp[i] = '0';
        }
        StringBuilder ans = new StringBuilder();
        if (indication) {
            ans.append('1');
            ans.append(temp);
        } else {
            int index = 0;
            while (index < s.length() && temp[index] == '0') index++;
            ans.append(temp, index, s.length() - index);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        BinaryNextNumber binaryNextNumber = new BinaryNextNumber();
        System.out.println(binaryNextNumber.binaryNextNumber("10"));
    }
}
