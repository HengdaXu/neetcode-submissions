class Solution {
    public int characterReplacement(String s, int k) {
        // most frequent character
        Map<Character, Integer> freq = new HashMap<>();
        int maxf = 0, res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, freq.get(s.charAt(r)));

            while (r - l + 1 - maxf > k){
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
