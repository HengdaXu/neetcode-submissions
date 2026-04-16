class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int i, int target, List<Integer> curr){
        if (target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if (target < 0 || i >= candidates.length) return;

        curr.add(candidates[i]);
        dfs(candidates, i + 1, target - candidates[i], curr);
        curr.remove(curr.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }

        dfs(candidates, i + 1, target, curr);
    }
}
