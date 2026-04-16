class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = 0, globalMax = Integer.MIN_VALUE;
        for (int num: nums){
            curMax = Math.max(curMax + num, num);
            globalMax = Math.max(curMax, globalMax);
        }
        return globalMax;
    }
}
