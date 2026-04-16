class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for (int num: nums){
            if (!map.containsKey(num)){
                map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);
            }
            map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
            map.put(num + map.getOrDefault(num + 1, 0), map.get(num));
            res = Math.max(map.get(num), res);
        }

        return res;
    }
}
