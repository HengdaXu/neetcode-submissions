class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 2) q.offer(new int[]{r, c});
                if (grid[r][c] == 1) fresh++;
            }
        }

        int res = 0;
        while (fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for (int[] dir: directions){
                    int dr = r + dir[0], dc = c + dir[1];
                    if (dr >= 0 && dr < m && dc >= 0 && dc < n && grid[dr][dc] == 1){
                        fresh--;
                        grid[dr][dc] = 2;
                        q.offer(new int[]{dr, dc});
                    }
                }
            }
            res++;
        }
        return (fresh == 0) ? res : -1;
    }
}
