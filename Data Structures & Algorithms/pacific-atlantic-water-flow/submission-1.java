class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for (int i = 0; i < m; i++){
            pacQueue.offer(new int[]{i, 0});
            atlQueue.offer(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++){
            pacQueue.offer(new int[]{0, j});
            atlQueue.offer(new int[]{m - 1, j});
        }

        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (pac[r][c] && atl[r][c]) res.add(Arrays.asList(r, c));
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights){
        while (!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            ocean[r][c] = true;
            for (int[] dir: directions){
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) q.offer(new int[]{nr, nc});
            }
        }
    }
}
