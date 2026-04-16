class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++){
            r = Math.max(r, i + nums[i]);

            if (i == l){
                steps++;
                l = r;
            }
        }
        return steps;
    }
}
