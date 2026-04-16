class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();

        int res = 0, l = 0;
        for (int i=0; i < s.length(); i++){
            while (map.contains(s.charAt(i))){
                map.remove(s.charAt(l));
                l++;
            }
            map.add(s.charAt(i));
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
