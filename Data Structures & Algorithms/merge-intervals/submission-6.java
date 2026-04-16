class Solution {
    public int[][] merge(int[][] intervals) {
        int maxWindow = 0;
        for (int[] interval: intervals){
            maxWindow = Math.max(interval[1], maxWindow);
        }

        int[] window = new int[maxWindow + 1];
        for (int[] interval: intervals){
            int s = interval[0], e = interval[1];
            window[s] = Math.max(e + 1, window[s]);
        }

        int start = -1, end = -1, index = 0;
        for (int i = 0; i < window.length; i++){
            if (window[i] != 0){
                if (start == -1) start = i;
                end = Math.max(window[i] - 1, end);
            }
            if (end == i){
                intervals[index++] = new int[]{start, end};
                start = end = -1;
            }
        }

        if (start != -1) intervals[index++] = new int[]{start, end};
        if (index == intervals.length) return intervals;

        int[][] res = new int[index][];
        for (int i = 0; i < index; i++){
            res[i] = intervals[i];
        }
        return res;

    }
}
