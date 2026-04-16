class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) return false;

        DSU dsu = new DSU(n);

        for (int[] edge: edges){
            if (!dsu.union(edge[0], edge[1])) return false;
        }

        return dsu.components() == 1;

    }
}

class DSU{
    int[] parent;
    int[] size;
    int component;

    public DSU(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        component = n;
        for (int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int v){
        if (parent[v] != v){
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    public boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (size[pu] >= size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        component--;
        return true;
    }

    public int components(){
        return component;
    }
}
