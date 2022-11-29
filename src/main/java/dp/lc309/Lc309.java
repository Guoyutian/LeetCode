package dp.lc309;

public class Lc309 {
    public int maxProfit(int[] p) {
        int n = p.length;
        if (n < 2) return 0;

        int[] hold = new int[n + 1]; // after buy
        int[] sell = new int[n + 1]; // after sell
        hold[1] = -p[0];
        for (int i = 2; i <= n; i++) {
            hold[i] = Math.max(hold[i - 1], sell[i - 2] - p[i - 1]);
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + p[i - 1]);
        }
        return sell[n];
    }
}
