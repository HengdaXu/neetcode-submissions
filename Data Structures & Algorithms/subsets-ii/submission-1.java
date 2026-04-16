class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++){
            start = (i >= 1 && nums[i] == nums[i - 1]) ? end : 0;
            end = res.size();
            for (int j = start; j < end; j++){
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
