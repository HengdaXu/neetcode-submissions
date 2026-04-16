class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";

        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have = 0, need = mapT.size();
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int l = 0;
        HashMap<Character, Integer> mapS = new HashMap<>();
        for (int r = 0; r < s.length(); r++){
            char tmp = s.charAt(r);
            mapS.put(tmp, mapS.getOrDefault(tmp, 0) + 1);
            if (mapT.containsKey(tmp) && mapS.get(tmp).equals(mapT.get(tmp))) have++;

            while (have == need){
                if (r - l + 1 < resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                
                char left = s.charAt(l);
                mapS.put(left, mapS.get(left) - 1);
                if (mapT.containsKey(left) && mapS.get(left) < (mapT.get(left))) have--;
                l++;
            }
        }
        return (resLen == Integer.MAX_VALUE) ? "" : s.substring(res[0], res[1] + 1);
    }
}
