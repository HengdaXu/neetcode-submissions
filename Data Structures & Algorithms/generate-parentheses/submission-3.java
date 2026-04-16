class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        StringBuilder level = new StringBuilder();
        res = new ArrayList<>();
        dfs(0, 0, level, n);
        return res;
    }

    private void dfs(int open, int close, StringBuilder sb, int n){
        if (close == n){
            res.add(sb.toString());
        }

        if (open < n){
            sb.append('(');
            dfs(open + 1, close, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open){
            sb.append(')');
            dfs(open, close + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
