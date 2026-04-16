class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++){
            r = Math.max(map.get(s.charAt(i)), r);
            if (i == r){
                res.add(r - l + 1);
                l = r + 1;
            }
        }

        return res;
    }
}
