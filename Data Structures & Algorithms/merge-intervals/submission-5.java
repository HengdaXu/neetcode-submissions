class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] curr = null;
        List<int[]> res = new ArrayList<>();
        for (int[] interval: intervals){
            if (curr == null){
                curr = interval;
            }else if (interval[0] > curr[1]){
                res.add(curr);
                curr = interval;
            }else{
                curr[0] = Math.min(curr[0], interval[0]);
                curr[1] = Math.max(curr[1], interval[1]);
            }
        }
        if (curr != null) res.add(curr);

        return res.toArray(new int[res.size()][]);
    }
}
