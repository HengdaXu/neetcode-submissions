class Solution {
    public boolean canPartition(int[] nums) {
        int s = Arrays.stream(nums).sum();
        int n = nums.length;

        if (s % 2 == 1) return false;

        int target = s/2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= target; j++){
                if (nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];

    }
}
