class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = 0;
        int res = Integer.MIN_VALUE;
        for (int num: nums){
            curMax += num;
            curMax = Math.max(num, curMax);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
