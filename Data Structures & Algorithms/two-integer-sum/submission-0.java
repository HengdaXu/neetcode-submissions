class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int dif = target - nums[i];
            if (map.containsKey(dif)) return new int[]{map.get(dif), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
