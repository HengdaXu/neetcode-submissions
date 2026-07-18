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
        HashMap<Node, Node> tree = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        if (node == null) return node;

        q.offer(node);
        tree.put(node, new Node(node.val));
        
        while (!q.isEmpty()){
            Node n = q.poll();
            for (Node nei: n.neighbors){
                if (!tree.containsKey(nei)) q.offer(nei);
                tree.put(nei, tree.getOrDefault(nei, new Node(nei.val)));
                tree.get(n).neighbors.add(tree.get(nei));
            }
        }
        return tree.get(node);
    }
}