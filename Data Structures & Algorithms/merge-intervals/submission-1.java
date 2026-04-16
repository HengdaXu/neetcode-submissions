class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = null;
        for (int[] interval: intervals){
            if (prev == null){
                prev = interval;
            }else if (interval[1] < prev[0]){
                res.add(interval);
            }else if (interval[0] > prev[1]){
                res.add(prev);
                prev = interval;
            }else{
                prev[0] = Math.min(prev[0], interval[0]);
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }

        if (prev != null) res.add(prev);
        return res.toArray(new int[res.size()][]);
    
    }
}
