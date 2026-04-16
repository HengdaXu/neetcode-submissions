class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i < nums.length; i++){
            if (nums[i] > 0) break;
            int target = - nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
  
            int l = i+1, r = nums.length - 1;
            while (l < r){
                if (nums[l] + nums[r] > target){
                    r--;
                }else if (nums[l] + nums[r] < target){
                    l++;
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    r--; 
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
                
            }
        }
        return res;
    }
}
