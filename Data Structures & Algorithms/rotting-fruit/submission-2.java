class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        m = grid.length;
        n = grid[0].length;
        
        int fresh = 0;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1) fresh++;
                if (grid[r][c] == 2){
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                } 
            }
        }
        int mins = 0;
        while (!q.isEmpty() && fresh > 0){
            int size = q.size();
            System.out.println(size);
            for (int i = 0; i < size; i++){
                int[] loc = q.poll();
                int r = loc[0], c = loc[1];
                for (int[] dir: directions){
                    int dr = dir[0] + r, dc = dir[1] + c;
                    if (dr < 0 || dr >= m || dc < 0 || dc >= n || visited[dr][dc] || grid[dr][dc] == 0) continue;
                    visited[dr][dc] = true;
                    grid[dr][dc] = 2;
                    fresh--;
                    q.offer(new int[]{dr, dc});
                }
            }
            mins++;
        }

        return (fresh == 0) ? mins : -1;


    }
}
