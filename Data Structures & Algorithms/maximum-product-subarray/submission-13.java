class Solution {
    public int maxProduct(int[] nums) {
        int maxP = nums[0];
        int minP = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            int tmp = maxP, num = nums[i];
            maxP = Math.max(Math.max(maxP * num, minP * num), num);
            minP = Math.min(Math.min(tmp * num, minP * num), num);
            res = Math.max(maxP, res);
        }
        return res;
    }
}
