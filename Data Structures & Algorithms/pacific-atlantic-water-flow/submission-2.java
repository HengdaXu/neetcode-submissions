class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++){
            dfs(heights, pac, i, 0);
            dfs(heights, atl, i, n - 1);
        }

        for (int j = 0; j < n; j++){
            dfs(heights, pac, 0, j);
            dfs(heights, atl, m - 1, j);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (pac[r][c] && atl[r][c]) res.add(Arrays.asList(r, c));
            }
        }
        return res;  
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c){
        ocean[r][c] = true;

        for (int[] dir: directions){
            int nr = dir[0] + r, nc = dir[1] + c;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) dfs(heights, ocean, nr, nc);
        }
    }
}
