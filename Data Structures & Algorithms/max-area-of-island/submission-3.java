class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int res = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1){
                    int curr = dfs(grid, r, c);
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        int area = 1;
        for (int[] dir: directions){
            int dr = r + dir[0], dc = c + dir[1];
            area += dfs(grid, dr, dc);
        }
        return area;
    }
}
