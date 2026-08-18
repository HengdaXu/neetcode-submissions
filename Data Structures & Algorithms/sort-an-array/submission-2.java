class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r){
        if (l >= r) return;
        int mid = (l + r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r, mid);
    }

    public void merge(int[] nums, int l, int r, int m){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = l;
        int j = m + 1;

        while (i <= m && j <= r){
            if (nums[i] <= nums[j]){
                temp.add(nums[i++]);
            }else{
                temp.add(nums[j++]);
            }
        }

        while (i <= m){
            temp.add(nums[i++]);
        }

        while (j <= r){
            temp.add(nums[j++]);
        }

        for (i = l; i <= r; i++){
            nums[i] = temp.get(i - l);
        }
    }
}