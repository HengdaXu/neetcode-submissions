class Solution {
    public int maxProduct(int[] nums) {
        int maxP = 1, minP = 1;
        int n = nums.length;
        int res = nums[0];

        for (int i = 0; i < n; i++){
            int tmp = maxP * nums[i];
            maxP = Math.max(nums[i], Math.max(nums[i] * maxP, nums[i] * minP));
            minP = Math.min(nums[i], Math.min(tmp, nums[i] * minP));
            res = Math.max(maxP, res);
        }

        return res;
    }
}
