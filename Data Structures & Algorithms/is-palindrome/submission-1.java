class Solution {
    public boolean isPalindrome(String s) {
        String ss = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0, j = ss.length() - 1;

        while (j > i){
            if (ss.charAt(i) != ss.charAt(j)){
                return false;
            }
            i++; 
            j--;
        }
        return true;
    }
}
