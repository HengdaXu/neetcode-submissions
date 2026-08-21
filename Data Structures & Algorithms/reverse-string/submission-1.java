class Solution {
    public void reverseString(char[] s) {
        int r = 0, l = s.length - 1;
        while (r < l){
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            r++; l--;
        }
    }
}