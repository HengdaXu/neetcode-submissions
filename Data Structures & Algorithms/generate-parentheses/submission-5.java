class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, "");
        return res;
    }

    public void dfs(int n, int left, int right, String cur) {
        if (left == n && left == right) res.add(cur);

        if (left <= n){
            dfs(n, left + 1, right, cur + "(");
        }

        if (right < left){
            dfs(n, left, right + 1, cur + ")");
        }

        return;
    }
}
