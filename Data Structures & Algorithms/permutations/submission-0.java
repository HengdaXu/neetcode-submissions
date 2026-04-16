class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        dfs(nums, new ArrayList<>(), new boolean[nums.length]);

        return res;
        
    }

    private void dfs(int[] nums, List<Integer> perm, boolean[] p){
        if (perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i=0; i < nums.length; i++){
            if (!p[i]){
                perm.add(nums[i]);
                p[i] = true;
                dfs(nums, perm, p);
                perm.remove(perm.size() - 1);
                p[i] = false;
            }
        }
    }
}
