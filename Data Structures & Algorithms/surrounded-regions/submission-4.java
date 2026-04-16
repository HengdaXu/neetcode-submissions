class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O'){
                board[i][0] = 'T';
                q.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O'){
                board[i][n - 1] = 'T';
                q.offer(new int[]{i, n - 1});
            }
        }

        for (int j = 0; j < n; j++){
            if (board[0][j] == 'O'){
                board[0][j] = 'T';
                q.offer(new int[]{0, j});
            }
            if (board[m - 1][j] == 'O'){
                board[m - 1][j] = 'T';
                q.offer(new int[]{m - 1, j});
            }
        }

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int[] dir: directions){
                int dr = r + dir[0], dc = c + dir[1];
                if (dr >= 0 && dr < m && dc >= 0 && dc < n && board[dr][dc] == 'O'){
                    board[dr][dc] = 'T';
                    q.offer(new int[]{dr, dc});
                }
            }
        }

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }
}
