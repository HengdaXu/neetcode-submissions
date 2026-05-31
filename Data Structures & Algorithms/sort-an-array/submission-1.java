class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n/2 - 1; i >= 0; i--){
            bubbleDown(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--){
            swap(nums, i, 0);
            bubbleDown(nums, i, 0);
        }
        return nums;

    }

    public void bubbleDown(int[] nums, int heapSize, int i){
        while (true){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int largest = i;

            if (left < heapSize && nums[left] > nums[largest]){
                largest = left;
            }

            if (right < heapSize && nums[right] > nums[largest]){
                largest = right;
            }

            if (largest == i){
                break;
            }

            swap(nums, largest, i);
            i = largest;
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}