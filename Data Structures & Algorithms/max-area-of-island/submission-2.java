class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1){
                    res = Math.max(res, dfs(grid, r, c));
                }
            }
        }
        return res; 
    }

    public int dfs(int[][] grid, int r, int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        int res = 1;
        for (int[] dir: directions){
            int nr = r + dir[0], nc = c + dir[1];
            res += dfs(grid, nr, nc);
        }
        return res;
    }
}
