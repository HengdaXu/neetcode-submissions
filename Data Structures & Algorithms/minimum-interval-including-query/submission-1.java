class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int i = 0;
        int[] res = new int[queries.length];
        for (int q: Arrays.stream(queries).sorted().toArray()){
            while (i < intervals.length && intervals[i][0] <= q){
                int l = intervals[i][0], r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }

           map.put(q ,(minHeap.isEmpty()) ? -1 : minHeap.peek()[0]);
        }

        for (int j = 0; j < queries.length; j++){
            res[j] = map.get(queries[j]);
        }

    
        return res;

    }
}
