class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int res = 0;
        while (l < r){
            int area = (r - l) * Math.min(heights[l], heights[r]);
            if (heights[l] >= heights[r]){
                r--;
            }else{
                l++;
            }
            res = Math.max(res, area);
        }
        return res;
    }
}
