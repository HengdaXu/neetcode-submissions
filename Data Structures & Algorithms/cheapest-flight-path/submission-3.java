class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        int i = 0;
        while (i++ <= k){
            int[] copyCost = Arrays.copyOf(cost, n);
            for (int[] flight: flights){
                int u = flight[0];
                int v = flight[1];
                int c = flight[2];

                if (cost[u] == Integer.MAX_VALUE) continue;

                if (copyCost[v] > cost[u] + c){
                    copyCost[v] = cost[u] + c;
                }
            }
            cost = copyCost;
        }
        return (cost[dst] == Integer.MAX_VALUE) ? -1 : cost[dst];
    }
}
