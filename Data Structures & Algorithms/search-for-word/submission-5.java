class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (dfs(board, visited, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int r, int c, int i){
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || board[r][c] != word.charAt(i)) return false;
        if (i + 1 == word.length()) return true;
    
        visited[r][c] = true;
        for (int[] dir: directions){
            int dr = r + dir[0], dc = c + dir[1];
            if (dfs(board, visited, word, dr, dc, i + 1)) return true;
        }
        visited[r][c] = false;
        return false;
    }
}
