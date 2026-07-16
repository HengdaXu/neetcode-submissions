class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);

        }

        int needed = freq.size();
        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0;
        int l = 0, r = 0, minLen = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};
        while (r < s.length()){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (freq.containsKey(c) && window.get(c).equals(freq.get(c))){
                have++;   
            }
            while (have == needed){
                if (r - l + 1 < minLen){
                    minLen = r - l + 1;
                    res[0] = l; res[1] = r;
                }

                char d = s.charAt(l);
                window.put(d, window.get(d) - 1);
                if (freq.containsKey(d) && window.get(d) < (freq.get(d))){
                    have--;
                }
                l++;  
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
