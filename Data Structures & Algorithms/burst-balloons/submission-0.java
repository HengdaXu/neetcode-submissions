class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] full = new int[n + 2];
        full[0] = full[n + 1] = 1;

        for (int i = 0; i < n; i++){
            full[i+1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int l = n; l >= 1; l--){
            for (int r = l; r <= n; r++){
                for (int i = l; i <= r; i++){
                    int coins = full[l - 1] * full[i] * full[r + 1]; 
                    coins += dp[l][i-1] + dp[i + 1][r];
                    dp[l][r] = Math.max(coins, dp[l][r]);
                }
            }
        }
        return dp[1][n];
    }
}
