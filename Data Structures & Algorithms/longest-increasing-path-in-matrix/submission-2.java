class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = 1;
                for (int[] dir: directions){
                    int dr = i + dir[0], dc = j + dir[1];
                    if (dr >= 0 && dr < m && dc >= 0 && dc < n && matrix[dr][dc] < matrix[i][j]) indegree[i][j]++;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (indegree[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        int res = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int[] dir: directions){
                    int dr = r + dir[0], dc = c + dir[1];
                    if (dr >= 0 && dr < m && dc >= 0 && dc < n && matrix[dr][dc] > matrix[r][c]){
                        if (--indegree[dr][dc] == 0){
                            q.offer(new int[]{dr, dc});
                            dp[dr][dc] = Math.max(1 + dp[r][c], dp[dr][dc]);
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
}
