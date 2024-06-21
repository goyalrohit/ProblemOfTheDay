//You are given a string str containing two fractions a/b and c/d, compare them and return the greater. If they are equal, then return "equal".
//Note: The string str contains "a/b, c/d"(fractions are separated by comma(,) & space( )).
//Examples
//Input: str = "5/6, 11/45"
//Output: 5/6
//Explanation: 5/6=0.8333 and 11/45=0.2444, So 5/6 is greater fraction.

public class TwoFractions {

    String compareFrac(String str) {
        // Code here
        String[] fractions = str.split(", ");
        String[] frac1 = fractions[0].split("/");
            String[] frac2 = fractions[1].split("/");
            int num1 = Integer.parseInt(frac1[0]);
            int den1 = Integer.parseInt(frac1[1]);
            int num2 = Integer.parseInt(frac2[0]);
            int den2 = Integer.parseInt(frac2[1]);
            int res1 = num1 * den2;
            int res2 = num2 * den1;
                if (res1 > res2) {
                return fractions[0];
            } else if (res1 < res2) {
                return fractions[1];
            } else {
                return "equal";
            }
    }

    public static void main(String[] args) {
        TwoFractions  twoFractions = new TwoFractions();
        System.out.println(twoFractions.compareFrac("5/6, 11/45"));
    }
}
