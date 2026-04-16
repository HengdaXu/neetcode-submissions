class Solution {
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int normal = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 0) q.offer(new int[]{r, c});
            }
        }

        while (!q.isEmpty()){
            int[] coor = q.poll();
            int r = coor[0], c = coor[1];
            for (int[] dir: directions){
                int nr = dir[0] + r, nc = dir[1] + c;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == normal){
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 1 + grid[r][c];
                }
            }
        }
    }
}
