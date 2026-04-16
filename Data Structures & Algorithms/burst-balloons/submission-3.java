class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n + 2];
        Arrays.fill(copy, 1);
        for (int i = 0; i < n; i++){
            copy[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];

        for (int l = n; l > 0; l--){
            for (int r = l; r <= n; r++){
                for (int i = l; i <= r; i++){
                    int curr = copy[l - 1] * copy[i] * copy[r + 1];
                    dp[l][r] = Math.max(dp[l][i - 1] + dp[i + 1][r] + curr, dp[l][r]);
                }
            }
        }
        return dp[1][n];
    }
}
