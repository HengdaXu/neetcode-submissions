class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length, i = 0;
        int[] res = new int[n * 2];
        for (int num: nums){
            res[i] = res[i + n] = num;
            i++;
        }
        return res;
    }
}