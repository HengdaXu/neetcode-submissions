class Solution {
    List<List<String>> res;
    boolean[] hor, dia1, dia2;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        hor = new boolean[n];
        dia1 = new boolean[2*n];
        dia2 = new boolean[2*n];
        dfs(0, new ArrayList<>());
        return res;

    }

    private void dfs(int r, List<String> cur){
        if (r == n){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int c = 0; c < n; c++){
            if (hor[c] || dia1[r + c] || dia2[r - c + n - 1]) continue;

            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[c] = 'Q';
            cur.add(new String(line));

            hor[c] = dia1[r + c] = dia2[r - c + n - 1] = true;
            dfs(r + 1, cur);
            hor[c] = dia1[r + c] = dia2[r - c + n - 1] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
