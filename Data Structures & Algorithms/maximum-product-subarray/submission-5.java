class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], curMax = 1, curMin = 1;

        for (int num: nums){
            int tmp = curMax * num;
            curMax = Math.max(num, Math.max(curMax * num, curMin * num));
            curMin = Math.min(num, Math.min(tmp, curMin * num));
            res = Math.max(res, curMax);
        }

        return res;
    }
}
