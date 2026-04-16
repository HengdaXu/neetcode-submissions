class Solution {
    public int[] productExceptSelf(int[] nums) {
        int lp = 1;
        int[] res = new int[nums.length];
        
        for (int i=0; i < nums.length; i++){
            res[i] = lp;
            lp *= nums[i];
        }

        int rp = 1;
        for (int j=nums.length-1; j >= 0; j--){
            res[j] *= rp;
            rp *= nums[j];
        }

        return res;
    }
}  
