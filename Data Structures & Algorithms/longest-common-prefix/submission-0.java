class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        int i;
        for (i = 0; i < prefix.length(); i++){
            boolean cont = true;
            for (String str: strs){
                if (i >= str.length() || str.charAt(i) != prefix.charAt(i)){
                    cont = false;
                    break;
                }
            }
            if (!cont) break;
        }
        return prefix.substring(0, i);
    }
}