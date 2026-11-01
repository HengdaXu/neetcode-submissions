class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    public void dfs(int n, int left, int right, StringBuilder cur) {
        if (left == n && left == right) res.add(cur.toString());

        if (left < n){
            cur.append("(");
            dfs(n, left + 1, right,cur);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (right < left){
            cur.append(")");
            dfs(n, left, right + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }

        return;
    }
}
