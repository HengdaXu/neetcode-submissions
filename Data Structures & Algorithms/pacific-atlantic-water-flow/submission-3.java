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
        if (ocean[r][c]) return;
        ocean[r][c] = true;
        for (int[] dir: directions){
            int dr = r + dir[0], dc = c + dir[1];
            if (dr >= 0 && dr < m && dc >= 0 && dc < n && !ocean[dr][dc] && heights[dr][dc] >= heights[r][c]){
                dfs(heights, ocean, dr, dc);
            }
        }
    }
}
