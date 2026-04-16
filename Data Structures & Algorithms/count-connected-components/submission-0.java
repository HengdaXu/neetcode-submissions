class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visit = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++){
            if (!visit.contains(i)){
                res++;
                dfs(visit, adj, i, -1);
            }
        }

        return res;
    }

    private void dfs(Set<Integer> visit, List<List<Integer>> adj, int v, int p){
        if (visit.contains(v)) return;

        visit.add(v);
        for (int nei: adj.get(v)){
            if (nei == p) continue; // (1, 0) (0, 1) so if we already checked the 1, v = 0 and 1 is in its nei.

            dfs(visit, adj, nei, v);
        }
        return;
    }
}
