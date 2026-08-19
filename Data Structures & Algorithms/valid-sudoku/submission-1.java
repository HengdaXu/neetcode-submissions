class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        HashSet[] rows = new HashSet[9];
        HashSet[] cols = new HashSet[9];
        HashSet[] squares = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                int square = (r/3) * 3 + (c/3);
                char num = board[r][c];
                if (num == '.') continue;
                if (rows[r].contains(num) || cols[c].contains(num) || squares[square].contains(num)) return false;
                rows[r].add(num);
                cols[c].add(num);
                squares[square].add(num);
            }
        }
        return true;
    }
}
