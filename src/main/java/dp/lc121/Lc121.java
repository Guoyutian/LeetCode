package dp.lc121;

public class Lc121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        // update the minimum price along the way
        // if current price is greater than the minimum price, update the profit
        // when calculating the profit in this way, we made sure that there were no better prices to buy from the past
        // also made sure that up to this point this is the best profit possible
        // each step after that is to gaurantee that.
        // ----------------------
        // another way ( in a DP way ) to see this is that:
        // at point i, profit[i] = (price[i] - lowestPriceFrom(0, i)); maxProfit = max(profit[i], profit[i-1])
        // so we can build the whole DP case from ground up

        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max((prices[i] - minPrice), maxProfit);
            }
        }

        return maxProfit;
    }
}
