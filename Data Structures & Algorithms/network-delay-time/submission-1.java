class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[]{dist[k], k});

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] path: times){
            adj.get(path[0]).add(new int[]{path[2], path[1]});
        }
        
        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            int distance = node[0];
            int start = node[1];

            if (visited.contains(start)) continue;
            visited.add(start);
            t = distance;

            if (distance > dist[start]) continue;

            for (int[] path: adj.get(start)){
                int weight = path[0];
                int end = path[1];
                System.out.println(start);
                System.out.println(end);
                if (dist[start] + weight < dist[end]){
                    dist[end] = dist[start] + weight;
                    minHeap.offer(new int[]{dist[end], end});
                }
            }
        }

        return visited.size() == n ? t : -1;

    }
}
