class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i=0; i < s.length(); i++){
            char temp = s.charAt(i);
            map1.put(temp, map1.getOrDefault(temp, 0) + 1);
        }

        for (int j=0; j < t.length(); j++){
            char temp2 = t.charAt(j);
            if (!map1.containsKey(temp2)){
                return false;
            }
            map2.put(temp2, map2.getOrDefault(temp2, 0) + 1);
            if (map1.get(temp2) < map2.get(temp2)){
                return false;
            }
        }
        return true;

    }
}
