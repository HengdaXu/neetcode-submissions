class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        int min = 0;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for (int i=0; i < size; i++){
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];
                for (int[] d: dir){
                    int r = row + d[0];
                    int c = col + d[1];

                    if (r >= m || r < 0 || c >= n || c < 0 || grid[r][c] != 1) continue;
                    q.add(new int[]{r, c});
                    grid[r][c] = 2;
                    fresh--;
                }
            } 
            min++;
        }
        return (fresh == 0) ? min : -1;
        
    }
}
