class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int needed = freq.size();
        int have = 0;
        int l = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int[] res = new int[]{-1, -1};
        int minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (freq.containsKey(c) && window.get(c).equals(freq.get(c))) have++;

            while (have == needed){
                if (r - l + 1 < minLen){
                    minLen = r - l + 1;
                    res[0] = l; res[1] = r;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if (freq.containsKey(left) && window.get(left) < freq.get(left)) have--;
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
