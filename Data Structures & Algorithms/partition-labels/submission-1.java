class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int farthest = 0;
        int curLen = 0;
        for (int i = 0; i < s.length(); i++){
            curLen++;
            farthest = Math.max(map.get(s.charAt(i)), farthest);
            if (i == farthest){
                res.add(curLen);
                curLen = 0;
            } 
        }

        return res;    
    }
}
