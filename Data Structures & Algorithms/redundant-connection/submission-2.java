class Solution {
    int[] parent, size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge: edges){
            if (!union(edge[0], edge[1])) return edge;
        }
        return new int[]{};
    }

    private int find(int v){
        if (parent[v] != v){
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (size[pu] >= size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        return true;
    }
}
