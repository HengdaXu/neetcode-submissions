class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> length = new HashMap<>();

        int res = 0;
        for (int num: nums){
            if (length.containsKey(num)) continue;
            length.put(num, length.getOrDefault(num - 1, 0) + 1 + length.getOrDefault(num + 1, 0));
            length.put(num - length.getOrDefault(num - 1, 0), length.get(num));
            length.put(num + length.getOrDefault(num + 1, 0), length.get(num));
            res = Math.max(length.get(num), res);
        }
        return res;
    }
}
