class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        for (int i = 0; i < n; i++){
            for (int[] edge: times){
                int u = edge[0] - 1;
                int v = edge[1] - 1;
                int d = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + d < dist[v]){
                    if (i == n - 1) break;
                    dist[v] = dist[u] + d;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
