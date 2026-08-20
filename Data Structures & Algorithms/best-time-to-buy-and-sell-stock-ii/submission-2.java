class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0; 
        int sell = 0; 

        for (int i = prices.length - 1; i >= 0; i--){
            // buying = 0 -> can buy
            // buying = 1 -> can sell
            int currBuy = Math.max(sell - prices[i], buy);
            int currSell = Math.max(buy + prices[i], sell);

            buy = currBuy;
            sell = currSell;
        }
        return buy;
    }
}