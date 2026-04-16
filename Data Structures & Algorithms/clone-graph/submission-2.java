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
        Map<Node, Node> copy = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if (node == null) return null;
        copy.put(node, new Node(node.val));
        q.offer(node);

        while (!q.isEmpty()){
            Node curr = q.poll();
            for (Node nei: curr.neighbors){
                if (!copy.containsKey(nei)){
                    copy.put(nei, new Node(nei.val));
                    q.offer(nei); 
                }
                copy.get(curr).neighbors.add(copy.get(nei));
            }
        }
        return copy.get(node);   
    }
}