class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                for (int[] dir: directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if (0 <= nr && nr < m && 0 <= nc && nc < n && matrix[nr][nc] < matrix[r][c]) indegree[r][c]++;
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
            for (int i = 0; i < size; i++){
                int[] node = q.poll();
                int r = node[0], c = node[1];
                for (int[] dir: directions){
                    int nr = r + dir[0], nc = c + dir[1];
                    if (0 <= nr && nr < m && 0 <= nc && nc < n && matrix[nr][nc] > matrix[r][c]){
                        if (--indegree[nr][nc] == 0) q.offer(new int[]{nr, nc});
                    }
                }
            }
            res++;
        }
        return res;
            
    }
}
