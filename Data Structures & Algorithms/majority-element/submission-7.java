class Solution {
    public int majorityElement(int[] nums) {
        int major = 0, res = 0;
        for (int num: nums){
            if (major == 0){
                res = num;
                major++;
            }
            major += (res == num) ? 1 : -1;
        }
        return res;
    }
}