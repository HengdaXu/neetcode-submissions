class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, n = prices.length, l = 0;

        for (int r = 0; r < n; r++){
            if (prices[r] - prices[l] >= res){
                res = prices[r] - prices[l];
            }else if (prices[r] - prices[l] < 0){
                l = r;
            }
        }
        return res;
    }
}
