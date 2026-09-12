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
        if (node == null) return node;
        HashMap<Node, Node> copy = new HashMap<>();

        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        copy.put(node, new Node(node.val, new ArrayList<>()));

        while (!q.isEmpty()){
            Node n = q.poll();
            Node c = copy.get(n);

            for (Node nei: n.neighbors){
                if (!copy.containsKey(nei)){
                    copy.put(nei, new Node(nei.val, new ArrayList<>()));
                    q.offer(nei);
                } 
                c.neighbors.add(copy.get(nei)); 
            }

        }
        return copy.get(node);

    }
}