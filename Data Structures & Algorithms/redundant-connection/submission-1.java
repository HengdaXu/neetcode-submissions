class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for (int i = 0; i <= edges.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge: edges){
            if (!union(parent, rank, edge[0], edge[1])){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[]{};


    }

    private int find(int[] parent, int v){
        if (v != parent[v]){
            parent[v] = find(parent, parent[v]);      
        }
        return parent[v];
    }

    private boolean union(int[] parent, int[] rank, int u, int v){
        int pu = find(parent, u), pv = find(parent, v);
        if (pu == pv) return false;
        if (rank[pu] >= rank[pv]){
            parent[pv] = pu;
            rank[pu] += rank[pv];
        }else{
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
        return true;
    }
}
