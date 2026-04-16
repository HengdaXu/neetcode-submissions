class Solution {
    public int search(int[] nums, int target) {
        int l=0, r = nums.length;

        while (l < r){
            int mid = l + (r - l)/2;
            if (nums[mid] <= target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }

        return (l > 0 && nums[l - 1] == target) ? l - 1 : -1;
    }
}
