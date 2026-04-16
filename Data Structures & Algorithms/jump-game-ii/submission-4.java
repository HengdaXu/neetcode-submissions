class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int farthest = 0;
        int curEnd = 0;
        for (int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, nums[i] + i);

            if (i == curEnd){
                res++;
                curEnd = farthest;
                if (curEnd >= nums.length - 1) return res;
            }
        }
        return res;
    }
}
