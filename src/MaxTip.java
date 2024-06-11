//In a restaurant, two waiters, A and B, receive n orders per day, earning tips as per arrays arr[i] and brr[i] respectively.
// If A takes the ith order, the tip is arr[i] rupees; if B takes it, the tip is brr[i] rupees.
//To maximize total tips, they must distribute the orders such that:
//A can handle at most x orders
//B can handle at most y orders
//Given that x + y ≥ n, all orders can be managed by either A or B. Return the maximum possible total tip after processing all the orders.
//Examples
//Input: n = 5, x = 3, y = 3, arr = {1, 2, 3, 4, 5}, brr = {5, 4, 3, 2, 1}
//Output: 21
//Explanation: Person A will serve the 3rd, 4th and 5th order while person B will serve the rest so the total tip from A = 3+4+5 & B = 5 + 4 i.e. 21.
//Hint: To maximize the total tips earned by waiters A and B, you need to consider the constraints x and y.
// Think about how you can distribute the orders between A and B based on these constraints to achieve the maximum total tip.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxTip {
    public long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        return optimum(arr, brr, x, y, n);

    }
    // greedy
    static class Order{
        int a_tip;
        int b_tip;
        int diff;

        Order(int a_tip, int b_tip){
            this.a_tip = a_tip;
            this.b_tip = b_tip;
            this.diff = Math.abs(a_tip - b_tip);
        }
    }

    static long optimum(int arr[], int brr[], int x, int y, int n){

        ArrayList<Order> orders = new ArrayList<>();
        for(int i = 0; i < n; i++){
            orders.add(new Order(arr[i], brr[i]));
        }

        Collections.sort(orders, (o1, o2) -> Integer.compare(o1.diff, o2.diff));

        long ans = 0;
        for(int i = n - 1; i >= 0; i--){
            Order o = orders.get(i);
            if((o.a_tip >= o.b_tip && x > 0) || y <= 0){
                ans += o.a_tip;
                x--;
            }else{
                ans += o.b_tip;
                y--;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        MaxTip maxTip = new MaxTip();
        int n = 5;
        int x = 3;
        int y = 3;
        int[] arr = {1, 2, 3, 4, 5};
        int[] brr = {5, 4, 3, 2, 1};
        System.out.println(maxTip.maxTip(n, x, y, arr, brr));
    }
}
