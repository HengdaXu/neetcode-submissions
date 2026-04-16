class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int[] interval: intervals){
            max = Math.max(interval[1], max);
        }

        int[] mp = new int[max + 1];
        for (int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            mp[start] = Math.max(end + 1, mp[start]);
        }

        int start = -1;
        int end = -1;
        int r = 0;
        for (int i = 0; i < mp.length; i++){
            if (mp[i] != 0){
                if (start == -1) start = i;
                end = Math.max(mp[i] - 1, end);
            }

            if (end == i){
                intervals[r++] = new int[]{start, end};
                start = end = -1;
            }
        }

        if (start != -1){
            intervals[r++] = new int[]{start, end};
        }
        
        if (intervals.length == r) return intervals;

        int[][] res = new int[r][];
        for (int i = 0; i < r; i++){
            res[i] = intervals[i];
        }

        return res;
    }
}
