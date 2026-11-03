class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                boolean[][] visited = new boolean[m][n];
                if (dfs(board, visited, word, 0, r, c)) return true;
            }
        }

        return false;

    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int i, int r, int c){
        if (i >= word.length()) return true;

        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(i) || visited[r][c]) return false;
        visited[r][c] = true;

        for (int[] dir: directions){
            int dr = r + dir[0];
            int dc = c + dir[1];
            if (dfs(board, visited, word, i + 1, dr, dc)) return true;
        }

        visited[r][c] = false;

        return false;
    }
}
