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

        Set<Integer> visit = new HashSet<>();
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
            if (nei == p) continue;
            dfs(visit, adj, nei, v);
        }
    }
}
