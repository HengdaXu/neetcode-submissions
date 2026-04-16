class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] square = new int[9];

        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1';
                int sq = (i/3) * 3 + (j/3);

                if (((row[i] & (1 << num)) > 0) || ((col[j] & (1 << num)) > 0) || ((square[sq] & (1 << num)) > 0)) return false;

                row[i] |= (1 << num);
                col[j] |= (1 << num);
                square[sq] |= (1 << num);
            }
        }
        return true;
         
    }
}
