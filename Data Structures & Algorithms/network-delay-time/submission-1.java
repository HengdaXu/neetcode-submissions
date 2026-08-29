class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int[] net: times){
            int r = net[0] - 1, c = net[1] - 1, d = net[2];
            dist[r][c] = d;
        }

        for (int m = 0; m < n; m++){
            for (int u = 0; u < n; u++){
                for (int v = 0; v < n; v++){
                    if (dist[u][m] != Integer.MAX_VALUE && dist[m][v] != Integer.MAX_VALUE) dist[u][v] = Math.min(dist[u][v], dist[u][m] + dist[m][v]);
                }
            }
        }

        int res = 0, u = k - 1;
        for (int v = 0; v < n; v++){
            if (dist[u][v] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(dist[u][v], res);
        }
        return res;
    }
}
