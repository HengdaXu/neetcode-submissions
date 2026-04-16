class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length, COL = matrix[0].length;

        int l = 0, r = ROW * COL - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            int row = mid/COL, col = mid % COL;

            if (matrix[row][col] > target){
                r = mid - 1;
            }else if (matrix[row][col] < target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }

}
