class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] bound = new int[nums.length + 2];
        bound[0] = 1;
        bound[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++){
            bound[i+1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int l = n; l >= 1; l--){
            for (int r = l; r <= n; r++){
                for (int i = l; i <= r; i++){
                    int coin = bound[l - 1] * bound[i] * bound[r + 1];
                    coin += dp[l][i-1] + dp[i+1][r];
                    dp[l][r] = Math.max(coin, dp[l][r]);
                }
            }
        }

        return dp[1][n];


    }
}
