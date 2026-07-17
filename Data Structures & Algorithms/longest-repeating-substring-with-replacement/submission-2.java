class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        int l = 0, maxF = 0, res = 0, local = 0;
        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            
            if (freq.get(c) > maxF) maxF = freq.get(c);

            while (l < r && r - l + 1 - maxF > k){
                char a = s.charAt(l);
                freq.put(a, freq.get(a) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
