class Solution {
    public int findKthLargest(int[] nums, int k) {
        int kth = nums.length - k;

        return quickSelect(nums, 0, nums.length - 1, kth);
    }

    private int quickSelect(int[] nums, int left, int right, int k){
        int pivot = nums[right];
        int index = left;
        for (int i = left; i < right; i++){
            if (nums[i] <= pivot){
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index++] = tmp; 
            }
        }

        int tmp = nums[index];
        nums[index] = nums[right];
        nums[right] = tmp;

        if (index < k){
            return quickSelect(nums, index + 1, right, k);
        }else if (index > k){
            return quickSelect(nums, left, index - 1, k);
        }else{
            return nums[index];
        }
    }
}
