class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int l = 0, res = 0;
        for (int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            while (set.contains(tmp)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(tmp);
            res = Math.max(i - l + 1, res);
        }

        return res;
    }
}
