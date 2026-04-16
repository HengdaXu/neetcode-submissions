class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        // each coin have two way if coin < amount, we can increament current coin or
        // choose next one.
        for (int i = n - 1; i >= 0; i--){
            for (int j = 1; j <= amount; j++){
                if (coins[i] <= j){
                    dp[i][j] = dp[i + 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}
