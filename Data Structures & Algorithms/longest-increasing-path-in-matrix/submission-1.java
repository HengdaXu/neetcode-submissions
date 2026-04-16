class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                for (int[] dir: directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] < matrix[r][c]) indegree[r][c]++;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (indegree[r][c] == 0) q.offer(new int[]{r, c});
            }
        }

        int res = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i =0; i < size; i++){
                int[] cord = q.poll();
                for (int[] dir: directions){
                    int nr = cord[0] + dir[0], nc = cord[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[cord[0]][cord[1]]){
                        if (--indegree[nr][nc] == 0) q.offer(new int[]{nr, nc});
                    }
                }
            } 
            res++;
        }
        return res;
            
    }
}
