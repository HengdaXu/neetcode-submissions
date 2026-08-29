class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] network: times){
            adj.get(network[0]).add(new int[]{network[1], network[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];

            if (d > dist[u]) continue;

            for (int[] nei: adj.get(u)){
                int v = nei[0];
                int w = nei[1];

                if (dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                } 
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++){
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(dist[i], res);
        }
        return res;
    }
}
