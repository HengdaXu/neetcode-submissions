class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int r = 0; r < m; r++){
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][n - 1] == 'O') dfs(board, r, n - 1);
        }

        for (int c = 0; c < n; c++){
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[m - 1][c] == 'O') dfs(board, m - 1, c);
        }

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c){
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') return;
        board[r][c] = 'T';
        for (int[] dir: directions){
            int nr = r + dir[0], nc = c + dir[1];
            dfs(board, nr, nc);
        }
    }
}
