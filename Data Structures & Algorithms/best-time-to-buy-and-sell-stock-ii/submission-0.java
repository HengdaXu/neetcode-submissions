class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[prices.length + 1];

        for (int i = prices.length - 1; i >= 0; i--){
            // buying = 0 -> can buy
            // buying = 1 -> can sell
            for (int buying = 0; buying < 2; buying++){
                if (buying == 0){
                    buy[i] = Math.max(sell[i + 1] - prices[i], buy[i + 1]);
                }else{
                    sell[i] = Math.max(buy[i + 1] + prices[i], sell[i + 1]);
                }
            }
        }
        return buy[0];
    }
}