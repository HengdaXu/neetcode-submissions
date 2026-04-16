class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--){
            if (s.charAt(i) == '0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i + 1];
                if (i < n - 1){
                    int curr = s.charAt(i) - '0';
                    int next = s.charAt(i + 1) - '0';
                    if (curr == 1 && next >= 0 && next <= 9 || curr == 2 && next >= 0 && next <= 6){
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }
        return dp[0];
    }
}
