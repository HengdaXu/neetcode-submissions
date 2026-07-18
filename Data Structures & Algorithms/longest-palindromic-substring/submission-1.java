class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        dp[s.length()][s.length()] = true;
        
        int resLen = 0, resIdx = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j) && (j - i  + 1<= 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    resIdx = (j - i + 1) > resLen ? i : resIdx;
                    resLen = Math.max(j - i + 1, resLen);
                }
                
            }
        }
        return resLen == 0 ? "" : s.substring(resIdx, resIdx + resLen);

    }
}
