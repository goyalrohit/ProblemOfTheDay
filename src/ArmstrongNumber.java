//Armstrong Numbers
//You are given a 3-digit number n, Find whether it is an Armstrong number or not.
//An Armstrong number of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371.
//Note: Return "Yes" if it is an Armstrong number else return "No".
//Examples
//Input: n = 153
//Output: Yes
//Explanation: 153 is an Armstrong number since 13 + 53 + 33 = 153. Hence answer is "Yes".


public class ArmstrongNumber {
    static String armstrongNumber(int n){
        // code here
        int sum = 0;
        int temp = n;
        while(temp > 0){
            int digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }
        return sum == n ? "Yes" : "No";
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println(armstrongNumber(n));
    }
}
