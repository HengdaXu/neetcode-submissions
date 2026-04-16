class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; r++){
            if (board[r][0] == 'O') {
                board[r][0] = 'T';
                q.offer(new int[]{r, 0});
            }
            if (board[r][n - 1] == 'O') {
                board[r][n - 1] = 'T';
                q.offer(new int[]{r, n - 1});
            }
        }

        for (int c = 0; c < n; c++){
            if (board[0][c] == 'O') {
                board[0][c] = 'T';
                q.offer(new int[]{0, c});
            }
            if (board[m - 1][c] == 'O') {
                board[m - 1][c] = 'T';
                q.offer(new int[]{m - 1, c});
            }
        }



        while (!q.isEmpty()){
            int[] cor = q.poll();
            int r = cor[0], c = cor[1];
            for (int[] dir: directions){
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O'){
                    board[nr][nc] = 'T';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }else if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
        
    }
}
