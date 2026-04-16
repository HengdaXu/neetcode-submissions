class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, profit = 0;
        for (int i = 1; i < prices.length; i++){
            int p = prices[i] - prices[buy];
            if (p < 0) buy = i;
            profit = Math.max(p, profit);
        }
        return profit;
    }
}
