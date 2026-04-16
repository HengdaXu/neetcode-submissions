class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int res = 0, l = 0, max_f = 0;
        for (int r=0; r < s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            max_f = Math.max(max_f, map.get(s.charAt(r)));

            while (r - l + 1 - max_f > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
        
    }
}
