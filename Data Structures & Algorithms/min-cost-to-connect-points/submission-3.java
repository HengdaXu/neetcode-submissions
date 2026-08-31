class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashSet<Integer> size = new HashSet<>();
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.putIfAbsent(i, new ArrayList<>());
                adj.putIfAbsent(j, new ArrayList<>());
                adj.get(i).add(new int[]{dis, j});
                adj.get(j).add(new int[]{dis, i});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0});

        int res = 0;
        while (size.size() < n){
            int[] point = pq.poll();
            int u = point[1];

            if (size.contains(u)) continue;
            res += point[0];
            size.add(u);
            for (int[] nei: adj.getOrDefault(u, new ArrayList<>())){
                if (size.contains(nei[1])) continue;
                pq.offer(new int[]{nei[0], nei[1]});
            }
        }
        return res;
    }
}
