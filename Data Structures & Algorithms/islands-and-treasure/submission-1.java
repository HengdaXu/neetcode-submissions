class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r ++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 0) q.offer(new int[]{r, c});
            }
        }
        if (q.size() == 0) return;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] start = q.poll();
                int r = start[0], c = start[1];
                for (int[] dir: directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != Integer.MAX_VALUE) continue;
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 1 + grid[r][c];
                }
            }
        }

    }
}
