class NumMatrix {
    private int[][] preMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preMatrix = new int[m + 1][n + 1];

        for (int r = 0; r < m; r++){
            int preSum = 0;
            for (int c = 0; c < n; c++){
                preSum += matrix[r][c];
                int above = preMatrix[r][c + 1];
                preMatrix[r + 1][c + 1] = preSum + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1 + 1, c1 = col1 + 1, r2 = row2 + 1, c2 = col2 + 1;
        int topLeft = preMatrix[r1 - 1][c1 - 1];
        int left = preMatrix[r2][c1 - 1];
        int topRight = preMatrix[r1 - 1][c2];
        int sum = preMatrix[r2][c2];
        return sum - left - topRight + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */