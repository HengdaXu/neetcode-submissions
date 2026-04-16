class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1) fresh++;
                if (grid[r][c] == 2) q.offer(new int[]{r, c});
            }
        }

        int min = 0;
        while (fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cor = q.poll();
                int r = cor[0], c = cor[1];
                for (int[] dir: directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        System.out.println(min);
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            
            min++;
        }
        return (fresh == 0) ? min : -1;  
    }
}
