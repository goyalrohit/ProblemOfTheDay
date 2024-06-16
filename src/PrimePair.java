import java.util.Arrays;
//Given a number n, find out if n can be expressed as a+b, where both a and b are prime numbers. If such a pair exists, return the values of a and b, otherwise return [-1,-1] as an array of size 2.
//Note: If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, and a < c then  [a, b] is considered as our answer.
//Examples
//Input: n = 10
//Output: 3 7
//Explanation: There are two possiblities 3, 7 & 5, 5 are both prime & their sum is 10, but we'll pick 3, 7 as 3 < 5.


import java.util.ArrayList;
//Using Seive Algo
public class PrimePair {
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        boolean[]Nprime=new boolean[n+1];
        seive(Nprime);
        ArrayList<Integer>ans = new ArrayList<>();

        if(n<4){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int start=2;
        int end =n-1;
        while(start<=end){
            if(Nprime[start]==false && Nprime[end]==false && start+end==n){
                ans.add(start);
                ans.add(end);
                return ans;
            }
            else if(Nprime[start]==false && Nprime[end]==false && start+end>n){
                end--;
            }
            else if(Nprime[start]==false && Nprime[end]==false && start+end<n){
                start++;
            }
            else if(Nprime[start]==false && Nprime[end]==true){
                end--;
            }
            else if(Nprime[start]==true && Nprime[end]==false){
                start++;
            }
            else {
                start++;
                end--;
            }
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
    public static void seive(boolean[] Nprime){
        int n = Nprime.length;
        for(int i=2;i<Math.sqrt(n);i++){
            for(int j=2*i;j<n;j=j+i){
                Nprime[j]=true;
            }
        }
    }
    public static void main(String[] args) {
        int n = 10;
        ArrayList<Integer> primes = getPrimes(n);
        System.out.println(primes);
    }
}
