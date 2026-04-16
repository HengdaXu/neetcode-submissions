class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int mins = 0;
        while (fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] rotten = q.poll();
                int r = rotten[0], c = rotten[1];
                for (int[] dir: directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) continue;
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    fresh--;
                }
            }
            mins++;
        }

        return (fresh == 0) ? mins : -1;

    }
}
