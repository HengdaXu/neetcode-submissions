class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
        
    }

    private boolean dfs(char[][]board, String word, int r, int c, int i){
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(i)) return false;

        if (i + 1 == word.length()) return true;

        char temp = board[r][c];
        board[r][c] = '#';

        for (int[] dir: directions){
            int nr = r + dir[0], nc = c + dir[1];
            if (dfs(board, word, nr, nc, i + 1)){
                board[r][c] = temp;
                return true;
            }
        }

        board[r][c] = temp;
        return false;
    }
}
