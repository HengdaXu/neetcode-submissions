class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0, l = 0;

        for (int r = 0; r < n; r++){
            if (prices[r] - prices[l] < 0){
                l = r;
            }else{
                maxProfit = Math.max(prices[r] - prices[l], maxProfit);
            }
        }
        return maxProfit;
    }
}
