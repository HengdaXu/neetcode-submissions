class Solution {
    int INF = 2147483647;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 0){
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                } 
            }
        }

        while (!q.isEmpty()){
            int[] loc = q.poll();
            int r = loc[0], c = loc[1];
            int d = grid[r][c];
            for (int[] dir: directions){
                int dr = r + dir[0], dc = c + dir[1];
                if (dr < 0 || dr >= m || dc < 0 || dc >= n || grid[dr][dc] == -1 || visited[dr][dc]){
                    continue;
                }
                grid[dr][dc] = Math.min(grid[dr][dc], d + 1);
                q.offer(new int[]{dr, dc});
                visited[dr][dc] = true;
            }
        }
    }
}
