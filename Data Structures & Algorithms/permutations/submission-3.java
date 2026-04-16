class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        dfs(nums, visited, n, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, int n, List<Integer> curr){
        if (curr.size() == n){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                curr.add(nums[i]);
                dfs(nums, visited, n, curr);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            } 
        }  
    }
}
