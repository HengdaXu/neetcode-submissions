class Solution {
    int comp;
    int[] parent, size;
    public boolean validTree(int n, int[][] edges) {
        comp = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge: edges){
            if (!union(edge[0], edge[1])) return false;
        }
        return comp == 1;
    }

    private int find(int node){
        if (node == parent[node]){
            return node;
        }
        return find(parent[node]);
    }

    private boolean union(int a, int b){
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        if (size[pa] >= size[pb]){
            parent[pb] = pa;
            size[pa] += size[pb];
        }else{
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        comp--;
        return true;    
    }
}
