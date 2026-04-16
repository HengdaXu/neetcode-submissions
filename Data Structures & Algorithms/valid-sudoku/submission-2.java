class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] hor = new HashSet[9];
        Set<Integer>[] ver = new HashSet[9];
        Set<Integer>[] grid = new HashSet[9];

        for (int i = 0; i < 9; i++){
            hor[i] = new HashSet<>();
            ver[i] = new HashSet<>();
            grid[i] = new HashSet<>();
        }

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] == '.') continue;
                int cur = board[r][c];
                int g = (r/3) * 3 + (c/3);
                if (hor[r].contains(cur) || ver[c].contains(cur) || grid[g].contains(cur)) return false;
                hor[r].add(cur);
                ver[c].add(cur);
                grid[g].add(cur);   
            }
        }
        return true;

    }
}
