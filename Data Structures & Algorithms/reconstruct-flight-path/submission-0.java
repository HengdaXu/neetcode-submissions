class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket: tickets){
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>((a, b) -> a.compareTo(b)));
            adj.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        List<String> res = new ArrayList<>();
        dfs(adj, "JFK", res);
        Collections.reverse(res);
        return res;
        
    }

    public void dfs(HashMap<String, PriorityQueue<String>> adj, String src, List<String> res){
        PriorityQueue<String> nei = adj.getOrDefault(src, new PriorityQueue<>((a, b) -> a.compareTo(b)));
        while (!nei.isEmpty()){
            dfs(adj, nei.poll(), res);
        }
        res.add(src);
    }
}
