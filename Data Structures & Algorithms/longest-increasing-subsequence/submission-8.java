class Solution {
    public int lengthOfLIS(int[] nums) {
        int LIS = 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for (int i = 1; i < nums.length; i++){
            if (dp.get(dp.size() - 1) < nums[i]){
                LIS++;
                dp.add(nums[i]);
                continue;
            }

            int index = Collections.binarySearch(dp, nums[i]);
            index = (index < 0) ? -index - 1 : index;
            dp.set(index, nums[i]);
        }
        return LIS;
    }
}
