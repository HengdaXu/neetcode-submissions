class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        String lcp = strs[0];
        for (int i = 0; i < lcp.length(); i++){
            char c = lcp.charAt(i);
            boolean flag = true;
            for (String str: strs){
                if (i == str.length() || str.charAt(i) != c){
                    flag = false;
                    break;
                }
            }
            if (flag){
                res += c;
            }else{
                return res;
            }
        }
        return res;
    }
}