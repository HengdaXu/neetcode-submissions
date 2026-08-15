class Solution {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);

        // 0, 0, 1, 2, 2, 2, 3, 4
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                int tmp = nums[k];
                nums[k++] = nums[i];
                nums[i] = tmp;
            }
            
        }
        return k;
    }
}