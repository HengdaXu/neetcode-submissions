class Solution {
    int ROW, COL;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        ROW = grid.length;
        COL = grid[0].length;
        for (int r=0; r < ROW; r++){
            for (int c=0; c < COL; c++){
                if (grid[r][c] == 1) maxArea = Math.max(maxArea, dfs(grid, r, c));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c){
        if (r < 0 || r >= ROW || c < 0 || c >= COL || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        return 1 + dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);
    }
}
