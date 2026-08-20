class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int currPre = 0, res = 0;
        for (int i = 0; i < nums.length; i++){
            currPre += nums[i];
            res += freq.getOrDefault(currPre - k, 0);
            freq.put(currPre, freq.getOrDefault(currPre, 0) + 1);
        }
        return res;
    }
}