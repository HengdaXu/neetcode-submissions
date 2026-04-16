class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    dfs(grid, r, c);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for (int[] dir: directions){
            int dr = r + dir[0];
            int dc = c + dir[1];
            dfs(grid, dr, dc);
        }
    }
}
