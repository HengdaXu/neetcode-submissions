class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for (int i=0; i < n; i++){
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;

        int half = sum/2;
        boolean[][] dp = new boolean[n + 1][half + 1];

        for (int i=0; i < n; i++){
            dp[i][0] = true;
        }

        for (int i=1; i <= n; i++){
            for (int j = 1; j <= half; j++){
                if (nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][half];

        
    }
}
