class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] cost = new int[n][k + 2];
        for (int i = 0; i < n; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight: flights){
            adj.putIfAbsent(flight[0], new ArrayList<>());
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src, 0});
        cost[src][0] = 0;

        while (!pq.isEmpty()){
            int[] f = pq.poll();
            int cst = f[0], u = f[1], edgeCost = f[2];

            if (u == dst) return cst;
            if (edgeCost == k + 1) continue;
            
            if (cost[u][edgeCost] < cst) continue;

            for (int[] nei: adj.getOrDefault(u, new ArrayList<>())){
                int v = nei[0], w = nei[1], nextCost = edgeCost + 1;
                if (cost[v][nextCost] > cost[u][edgeCost] + w){
                    cost[v][nextCost] = cost[u][edgeCost] + w;
                    pq.offer(new int[]{cost[v][nextCost], v, nextCost});
                }
                
            }
        }
        return -1;
    }
}
