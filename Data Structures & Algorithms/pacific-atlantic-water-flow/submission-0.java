class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++){
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }

        for (int i = 0; i < n; i++){
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, m - 1, i);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r=0; r < m; r++){
            for (int c=0; c < n; c++){
                if (pacific[r][c] && atlantic[r][c]) res.add(Arrays.asList(r, c));
            }
        }

        return res; 
    }

    private void dfs(int[][]heights, boolean[][] ocean, int r, int c){
        ocean[r][c] = true;

        for (int[] dir: dirs){
            int rowd = r + dir[0];
            int cold = c + dir[1];
            if (rowd >= 0 && rowd < m && cold >= 0 && cold < n && !ocean[rowd][cold] && heights[rowd][cold] >= heights[r][c]) dfs(heights, ocean, rowd, cold);


        }
    }
}
