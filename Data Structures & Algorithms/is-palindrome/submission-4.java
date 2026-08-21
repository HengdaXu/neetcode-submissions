class Solution {
    public boolean isPalindrome(String s) {
        int r = 0, l = s.length() - 1;
        while (r < l){
            while (r < l && !Character.isLetterOrDigit(s.charAt(r))){
                r++;
            }
            while (r <l && !Character.isLetterOrDigit(s.charAt(l))){
                l--;
            }

            char left = Character.toLowerCase(s.charAt(r));
            char right = Character.toLowerCase(s.charAt(l));
            if (left != right) return false;
            r++; l--;
        }
        return true;
    }
}
