class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0, r = heights.length - 1;

        while (l < r){
            int area = (r - l) * Math.min(heights[l], heights[r]);
            if (area > res){
                res = area;
            }
            if (heights[l] >= heights[r]){
                r--;
            }else{
                l++;
            }
        }

        return res;
        
    }
}
