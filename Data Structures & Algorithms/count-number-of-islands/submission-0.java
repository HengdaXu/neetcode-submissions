class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == '1'){
                    res++;
                    q.offer(new int[]{r, c});
                    while (!q.isEmpty()){
                        int[] cord = q.poll();
                        int cr = cord[0], cc = cord[1];
                        grid[cr][cc] = '0';
                        for (int[] d: dir){
                            int sr = cr + d[0], sc = cc + d[1];
                            if ((0 <= sr && sr < n) && (0 <= sc && sc < m) && grid[sr][sc] == '1') q.offer(new int[]{sr, sc});
                        }
                    }
                }
            }
        }
        return res;
    }
}
