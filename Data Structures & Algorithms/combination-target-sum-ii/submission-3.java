class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;  
    }

    private void dfs(int[] nums, int target, List<Integer> cur, int i){
        if (target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i >= nums.length) return;

        cur.add(nums[i]);
        dfs(nums, target - nums[i], cur, i + 1);
        cur.remove(cur.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        dfs(nums, target, cur, i + 1);
    }
}
