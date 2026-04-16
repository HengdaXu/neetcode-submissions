class Solution {
    int R, C;
    public int numIslands(char[][] grid) {
        int res = 0;
        R = grid.length;
        C = grid[0].length;
        for (int r=0; r < R; r++){
            for (int c=0; c < C; c++){
                if (grid[r][c] == '1'){
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int r, int c){
        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '0') return;

        grid[r][c] = '0';
        
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}
