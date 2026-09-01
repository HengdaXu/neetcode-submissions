class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;

        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge: times){
            int u = edge[0] - 1, v = edge[1] - 1, c = edge[2];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k - 1});

        while (!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];

            if (d > distance[u]) continue;

            for (int[] nei: adj.getOrDefault(u, new ArrayList<>())){
                int v = nei[0];
                int w = nei[1];
                if (distance[v] > distance[u] + w){
                    distance[v] = distance[u] + w;
                    pq.offer(new int[]{distance[v], v});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            if (distance[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, distance[i]);
        }
        return res;
    }
}
