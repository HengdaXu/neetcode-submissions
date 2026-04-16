class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> e = new ArrayList<>();
        for (int i = 0; i < n; i++){
            e.add(new ArrayList<>());
        }

        for (int [] edg: edges){
            e.get(edg[0]).add(edg[1]);
            e.get(edg[1]).add(edg[0]);
        }

        Set<Integer> vertices = new HashSet<>();
        if (!dfs(vertices, e, 0, -1)) return false;
        return vertices.size() == n;
    }

    private boolean dfs(Set<Integer> vertices, List<List<Integer>> e, int v, int p){
        if (vertices.contains(v)) return false;
        vertices.add(v);

        for (int nei: e.get(v)){
            if (nei == p) continue;
            
            if (!dfs(vertices, e, nei, v)) return false;
        }
        return true;
    }
}
