class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (int[] edge: edges){
            dsu.union(edge[0], edge[1]);
        }
        return dsu.component();
    }
}

class DSU{
    int[] parent;
    int[] size;
    int comps;

    public DSU(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        comps = n;
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
        comps--;
        return true;
    }

    public int component(){
        return comps;
    }
}
