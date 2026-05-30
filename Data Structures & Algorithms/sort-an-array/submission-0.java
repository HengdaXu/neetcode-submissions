class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            bubbleDown(nums, n, i);
        }

        for (int end = n - 1; end > 0; end--) {
            swap(nums, 0, end);

            bubbleDown(nums, end, 0);
        }

        return nums;

    }

    public void bubbleDown(int[] nums, int heapSize, int i){
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < heapSize && nums[left] > nums[largest]) {
                largest = left;
            }

            if (right < heapSize && nums[right] > nums[largest]) {
                largest = right;
            }

            if (largest == i) {
                break;
            }

            swap(nums, i, largest);
            i = largest;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}