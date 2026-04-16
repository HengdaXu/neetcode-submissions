class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0, r = heights.length - 1;
        while (l < r){
            int area = Math.min(heights[r], heights[l]) * (r - l);
            if (heights[r] <= heights[l]){
                r--;
            }else{
                l++;
            }
            res = Math.max(area, res);
        }
        return res;
    }
}
