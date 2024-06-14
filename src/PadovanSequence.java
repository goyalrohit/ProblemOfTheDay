//Padovan Sequence
//Given a number n, find the nth number in the Padovan Sequence.
//A Padovan Sequence is a sequence which is represented by the following recurrence relation
//P(n) = P(n-2) + P(n-3)
//P(0) = P(1) = P(2) = 1
//Note: Since the output may be too large, compute the answer modulo 10^9+7.
//Examples :
//Input: n = 3
//Output: 2
//Explanation: We already know, P1 + P0 = P3 and P1 = 1 and P0 = 1


public class PadovanSequence {
    static int n1=0,n2=1,n3=0;
    public int padovanSequence(int n)
    {
        //code here.
        int[] arr = new int[n+1];
        if(arr.length >= 1)
            arr[0] = 1;
        if(arr.length >= 2)
            arr[1] = 1;
        if(arr.length >= 3)
            arr[2] = 1;
        for(int i=3;i<=n;i++){
            arr[i] = (arr[i-2] + arr[i-3])% 1000000007;
        }
        return arr[n];
    }


    public static void main(String[] args) {
        PadovanSequence padovanSequence = new PadovanSequence();
        int n = 3;
        System.out.println(padovanSequence.padovanSequence(n));
        System.out.print(0+" "+1);
        padovanSequence.fibonaci(8);
    }

    public static void fibonaci (int cnt){



        if (cnt > 0){
            n3 = n1+n2;
            n1= n2;
            n2=n3;
            System.out.print(" "+ n3);
            fibonaci(cnt -1);
        }

    }

}
