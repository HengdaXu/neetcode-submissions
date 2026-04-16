class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();

        int l = 0, res = 0;
        for (int r = 0; r < n; r++){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(r - l + 1, res);
        }
        return res;

    }
}
