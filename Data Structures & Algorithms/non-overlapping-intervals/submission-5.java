class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = null;
        for (int[] interval: intervals){
            if (curr == null){
                curr = interval;
            } else if (interval[0] >= curr[1]){
                res.add(curr);
                curr = interval;
            }else{
                curr = (curr[1] > interval[1]) ? interval : curr;
            }
        }
        if (curr != null) res.add(curr);
        return intervals.length - res.size();
    }
}
