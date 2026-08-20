class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            int prefix = nums[i];
            res += (prefix == k) ? 1 : 0;
            for (int j = i + 1; j < nums.length; j++){
                prefix += nums[j];
                res += (prefix == k) ? 1 : 0;
            }
        }
        return res;
    }
}