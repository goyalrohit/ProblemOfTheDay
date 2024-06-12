//You are given a number n, Return the count of total numbers from 1 to n containing 4 as a digit.

//Examples:
//Input: n = 9
//Output: 1
//Explanation: 4 is the only number between 1 to 9 which contains 4 as a digit.




public class CountNumberswith4 {
        public static int countNumberswith4(int n) {
            // code here
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (String.valueOf(i).contains("4")) {
                    count++;
                }
            }
            return count;
        }

    public static void main(String[] args) {
        System.out.print(countNumberswith4(9));
    }

    }