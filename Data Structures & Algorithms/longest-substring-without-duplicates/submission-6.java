class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> rep = new HashSet<>();
        int l = 0, r = 0, res = 0;
        while (r < s.length()){
            while (rep.contains(s.charAt(r))) {
                rep.remove(s.charAt(l++));
            }
            rep.add(s.charAt(r));
            res = Math.max(res, rep.size());
            r++;
        }

        return res;
    }
}
