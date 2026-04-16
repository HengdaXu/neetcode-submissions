class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < n; i++){
            int size = res.size();
            for (int j = 0; j < size; j++){
                List<Integer> curr = new ArrayList<>(res.get(j));
                curr.add(nums[i]);
                res.add(curr);
            }
        }
        return res;
    }
}
