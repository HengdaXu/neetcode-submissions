/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if (node == null) return null;
        map.put(node, new Node(node.val));
        q.offer(node);
        
        while (!q.isEmpty()){
            Node curr = q.poll();
            Node copy = map.get(curr);

            for (Node nei: curr.neighbors){
                if (!map.containsKey(nei)){ 
                    map.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                map.get(curr).neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}