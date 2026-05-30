class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != ans){
                if (count == 0){
                    count = 1;
                    ans = nums[i];
                }else{
                    count--;
                }
            }else{
                count++;
            }
        }
        return ans;
    }
}