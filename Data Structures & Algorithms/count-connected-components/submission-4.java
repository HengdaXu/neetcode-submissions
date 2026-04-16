class Solution {
    int[] parent, size;
    int comp;
    public int countComponents(int n, int[][] edges) {
        comp = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }


        for (int[] edge: edges){
            union(edge[0], edge[1]);
        }
        return comp;
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
        comp--;
        return true;
    }
}
