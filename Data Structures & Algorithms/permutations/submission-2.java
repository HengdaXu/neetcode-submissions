class Solution {
    int n;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        boolean[] choose = new boolean[n];
        
        dfs(nums, choose, new ArrayList<>());
        return res;

    }

    private void dfs(int[] nums, boolean[] choose, List<Integer> curr){
        if (curr.size() == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < n; i++){
            if (!choose[i]){
                choose[i] = true;
                curr.add(nums[i]);
                dfs(nums, choose, curr);
                choose[i] = false;
                curr.remove(curr.size() - 1);
            }
        }  
    }
}
