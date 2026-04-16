class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: t.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = freq.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            window.put(curr, window.getOrDefault(curr, 0) + 1);
            if (freq.containsKey(curr) && freq.get(curr).equals(window.get(curr))) have++;

            while (have == need){
                if ((r - l + 1) < resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if (freq.containsKey(left) && freq.get(left) > window.get(left)) have--;
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

    }
}
