class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> fr = new HashMap<>();

        int l = 0, res = 0, maxf = 0;
        for (int r = 0; r < n; r++){
            fr.put(s.charAt(r), fr.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(fr.get(s.charAt(r)), maxf);

            while (r - l + 1 - maxf > k){
                fr.put(s.charAt(l), fr.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;

    }
}
