//Extract the Number from the String
//Given a sentence containing several words and numbers. Find the largest number among them which does not contain 9. If no such number exists, return -1.
//Note: Numbers and words are separated by spaces only. It is guaranteed that there are no leading zeroes in the answer.

//Examples :
//Input: sentence="This is alpha 5057 and 97"
//Output: 5057
//Explanation: 5057 is the only number that does not have a 9.

public class ExtractNumber {
    long ExtractNumber(String sentence) {
        // code here
        String[] arr=sentence.split("\\s+");
        long largeNum=-1;
        for(int i=0;i<arr.length;i++){
            if(Character.isDigit(arr[i].charAt(0)) && !arr[i].contains("9")){
                long currNum=Long.parseLong(arr[i]);
                if(largeNum<currNum){
                    largeNum=currNum;
                }
            }
        }
        return largeNum;
    }

    public static void main(String[] args) {
        ExtractNumber en=new ExtractNumber();
        String sentence="This is alpha 5057 and 97";
        System.out.println(en.ExtractNumber(sentence));
    }
}
