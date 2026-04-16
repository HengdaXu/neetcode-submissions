class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), 0, 0, target);
        

        return res; 
    }

    private void dfs(int[] candidates, List<Integer> cur, int i, int total, int target){
        if (total == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j=i; j < candidates.length; j++){
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            if (total + candidates[j] > target) return;

            cur.add(candidates[j]);
            dfs(candidates, cur, j+1, total+candidates[j], target);
            cur.remove(cur.size() - 1);
        }

    }
}
