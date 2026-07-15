class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxAmount = 0;
        while (i <= j){
            int currAmount;
            int leftBar = heights[i], rightBar = heights[j];
            currAmount = Math.min(leftBar, rightBar) * (j - i);
            System.out.println(currAmount);
            maxAmount = Math.max(maxAmount, currAmount);
            i += (leftBar < rightBar) ? 1 : 0;
            j -= (leftBar >= rightBar) ? 1 : 0;
        }
        return maxAmount;
    }
}
