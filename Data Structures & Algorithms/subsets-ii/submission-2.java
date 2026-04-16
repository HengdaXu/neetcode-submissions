class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // [1, 1, 2]
        // [[]]
        // [[], [1]]
        // [[], [1], [1, 1]]
        // [[], [1], [1, 1], [2], [1, 2], [1, 1, 2]]

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++){
            l = (i >= 1 && nums[i] == nums[i - 1]) ? r : 0;
            r = res.size();

            for (int j = l; j < r; j++){
                List<Integer> copy = new ArrayList<>(res.get(j));
                copy.add(nums[i]);
                res.add(copy);
            }  
        }
        return res;
        
    }
}
