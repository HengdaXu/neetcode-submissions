class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        
        int res = 0, prefixSum = 0;
        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            res += prefix.getOrDefault(prefixSum - k, 0);
            
            prefix.put(prefixSum, prefix.getOrDefault(prefixSum, 0) + 1);
        } 

        return res;  
    }
}