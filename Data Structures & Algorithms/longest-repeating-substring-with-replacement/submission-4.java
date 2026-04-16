class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, n = s.length(), l = 0, maxF = 0;

        for (int r = 0; r < n; r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            while ((r - l + 1 - maxF > k)){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(r - l + 1, res);
        }

        return res;

        
    }
}
