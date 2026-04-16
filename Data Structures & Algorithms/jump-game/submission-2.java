class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--){
            lastPos = (i + nums[i] >= lastPos)? i : lastPos;
        }
        return lastPos == 0;
    }
}
