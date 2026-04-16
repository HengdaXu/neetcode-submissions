class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int maxP = nums[0], minP = nums[0];
        int res = Math.max(maxP, minP);
        for (int i = 1; i < nums.length; i++){
            int temp = Math.max(Math.max(maxP * nums[i], minP * nums[i]), nums[i]);
            minP = Math.min(Math.min(maxP * nums[i], minP * nums[i]), nums[i]);
            maxP = temp;
            res = Math.max(Math.max(maxP, minP), res);
        }
        return res; 
        
    }
}
