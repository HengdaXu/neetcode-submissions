class MyHashMap {
    private Node[] nodes;

    public MyHashMap() {
        this.nodes = new Node[1000001];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(-1, -1);
        }
    }
    
    public void put(int key, int value) {
        Node n = nodes[key%nodes.length];
        while (n.next != null){
            if (n.next.key == key){
                n.next.value = value;
                return;
            }
            n = n.next;
        }
        n.next = new Node(key, value);
    }
    
    public int get(int key) {
        Node n = nodes[key%nodes.length];
        while (n.next != null){
            if (n.next.key == key) return n.next.value;
            n = n.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node n = nodes[key%nodes.length];
        while (n.next != null){
            if (n.next.key == key){
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
    }
}

class Node{
    Node next;
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */