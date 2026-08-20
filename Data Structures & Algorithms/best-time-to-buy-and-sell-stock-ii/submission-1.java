class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;

        for (int i = prices.length - 1; i >= 0; i--){
            // buying = 0 -> can buy
            // buying = 1 -> can sell
            for (int buying = 0; buying < 2; buying++){
                if (buying == 0){
                    buy = Math.max(sell - prices[i], buy);
                }else{
                    sell = Math.max(buy + prices[i], sell);
                }
            }
        }
        return buy;
    }
}