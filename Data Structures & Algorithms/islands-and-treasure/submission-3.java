class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
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
            int[] curr = q.poll();
            for (int[] dir: directions){
                int dr = curr[0] + dir[0], dc = curr[1] + dir[1];
                if (dr >= 0 && dr < m && dc >= 0 && dc < n && grid[dr][dc] == Integer.MAX_VALUE){
                    grid[dr][dc] = grid[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{dr, dc});
                }
            }
        }
    }
}
