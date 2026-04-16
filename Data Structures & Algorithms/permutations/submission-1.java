class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, boolean[] copy, List<Integer> cur){
        if (cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!copy[i]){
                copy[i] = true;
                cur.add(nums[i]);
                dfs(nums, copy, cur);
                cur.remove(cur.size() - 1);
                copy[i] = false;
            }
        } 
    }
    
}
