class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, int[]> loc = new HashMap<>();
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid.length; c++){
                loc.putIfAbsent(grid[r][c], new int[]{r, c});
            }
        }

        DSU dsu = new DSU(n);

        int res = 0;
        int begin = grid[0][0], end = grid[n - 1][n - 1];
        while (dsu.find(begin) != dsu.find(end)){
            int[] cor = loc.get(res);
            for (int[] dir: directions){
                int dr = cor[0] + dir[0];
                int dc = cor[1] + dir[1];
                if (dr >= 0 && dr < n && dc >= 0 && dc < n && grid[dr][dc] < res){
                    dsu.union(res, grid[dr][dc]);
                    if (dsu.find(begin) == dsu.find(end)) return res;
                }
            }
            
            res++;
        }
        return res;
    }
}

class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        this.parent = new int[n*n];
        this.size = new int[n*n];
        for (int i = 0; i < n*n; i++) parent[i] = i;
        Arrays.fill(size, 1);
    }

    public int find(int node){
        if (parent[node] != node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (size[pu] < size[pv]){
            int tmp = pu;
            pu = pv;
            pv = tmp;
        }

        size[pu] += size[pv];
        parent[pv] = pu;
        return true;
    }
}
