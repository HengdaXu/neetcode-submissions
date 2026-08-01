class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        int del = 1;
        while (l < r){
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (lc != rc){
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++; r--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }
}