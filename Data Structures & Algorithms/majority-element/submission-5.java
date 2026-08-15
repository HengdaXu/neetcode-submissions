class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != res){
                if (--count < 0){
                    count = 1;
                    res = nums[i];
                }
            }else{
                count++;
            }
        }
        return res;
        
    }
}