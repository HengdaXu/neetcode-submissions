class Solution {
    // tree is a graph which does not contain cycle
    // dfs to trace each node, and mark it as visited;
    // if we encounter a node which was visited - mean we find a cycle -> return fals
    // becuase the graph is not a tree;
    public boolean validTree(int n, int[][] edges) {
        // for an undirected graph, if we have n vertices, we must have at most n - 1 edges;
        if (edges.length > n - 1) return false; // its not a valid graph.

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }


        for (int[] edge: edges){
            // we need to create two edges. one is (a, b), and another is (b, a);
            // for example, we have an edge (1, 0) and (1, 2)
            // adj[1] = [0, 2];
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        

        Set<Integer> visit = new HashSet<>();
        if (!dfs(visit, adj, 0, -1)) return false;

        // avoid the case for disconnected graph
        return visit.size() == n;


    }

    private boolean dfs(Set<Integer> visit, List<List<Integer>> adj, int v, int p){
        if (visit.contains(v)) return false;

        visit.add(v);
        for (int nei: adj.get(v)){
            if (nei == p) continue;

            if (!dfs(visit, adj, nei, v)) return false;
        }
        return true;

    }
}
