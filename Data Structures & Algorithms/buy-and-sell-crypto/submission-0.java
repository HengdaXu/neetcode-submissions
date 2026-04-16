class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int max_profit = 0;
        

        for (int i = 1; i < prices.length; i++){
            int profit = prices[i] - prices[buy];
            if (profit < 0){
                buy = i;
                continue;
            }
            max_profit = (profit > max_profit)? profit : max_profit;

        }

        return max_profit;
        
    }
}
