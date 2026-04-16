class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int res = 0;
        int curr = 0;
        int range = 0;
        for (int i = 0; i < nums.length; i++){
            range = Math.max(range, nums[i] + i);
            if (i == curr){
                res++;
                curr = range;
                if (curr >= nums.length - 1) break;
            }
        }
        return res;
    }
}
