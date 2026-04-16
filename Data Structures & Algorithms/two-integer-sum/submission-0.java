class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> difference = new HashMap<>();

        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (difference.containsKey(diff)){
                results[1] = i;
                results[0] = difference.get(diff);
                break;
            }
            difference.put(nums[i], i);
        }
        return results;
    }
}
