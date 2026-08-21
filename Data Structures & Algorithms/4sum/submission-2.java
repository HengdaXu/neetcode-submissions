class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r){
                    long sum =(long)nums[i] + nums[j] + nums[l] + nums[r];
                    System.out.println(sum);
                    if (sum == target){
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        l++;
                        while (l < r && nums[l] == nums[l - 1]){
                            l++;
                        }
                        r--;
                    }else if (sum > target){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }
        return res;
    }
}