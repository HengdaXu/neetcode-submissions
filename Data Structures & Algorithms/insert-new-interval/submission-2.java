class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int[] curr = newInterval;
        for (int[] interval: intervals){
            if (curr == null || interval[1] < curr[0]){
                res.add(interval);
            }else if (interval[0] > curr[1]){
                res.add(curr);
                res.add(interval);
                curr = null;
            }else{
                curr[0] = Math.min(curr[0], interval[0]);
                curr[1] = Math.max(curr[1], interval[1]);
            }
        }

        if (curr != null) res.add(curr);

        return res.toArray(new int[res.size()][]);
    }
}
