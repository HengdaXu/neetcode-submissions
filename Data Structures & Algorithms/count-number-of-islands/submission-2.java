class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == '1'){
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
        
    }

    private void dfs(char[][] grid, int r, int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') return;
        

        grid[r][c] = '0';
        for (int[] dir: directions){
            int nr = r + dir[0], nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }

}
