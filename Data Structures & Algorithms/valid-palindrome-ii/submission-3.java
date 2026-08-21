class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() -1, 1);
    }

    public boolean isPalindrome(String s, int r, int l, int count){
        while (r < l){
            if (s.charAt(r) != s.charAt(l)){
                if (count == 0) return false;
                return isPalindrome(s, r+1, l, 0) || isPalindrome(s, r, l-1, 0);
            }
            r++;
            l--;
        }
        return true;
    }
}