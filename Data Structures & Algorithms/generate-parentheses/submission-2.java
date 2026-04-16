class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(cur, n, 0, 0);
        return res;
    }

    private void dfs(StringBuilder cur, int n, int open, int close){
        if (open == close && open == n){
            res.add(cur.toString());
            return;
        } 

        if (open < n){
            cur.append("(");
            dfs(cur, n, open + 1, close);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open){
            cur.append(")");
            dfs(cur, n, open, close + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
