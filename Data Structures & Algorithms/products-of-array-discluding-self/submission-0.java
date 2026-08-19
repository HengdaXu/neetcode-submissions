class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++){
            res[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int j = nums.length - 1; j >= 0; j--){
            res[j] *= rightProduct;
            rightProduct *= nums[j];
        }
        return res;
    }
}  
