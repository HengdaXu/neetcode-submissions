class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.map = new HashMap<>();
        this.capacity = capacity;
        head.nxt = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        // remove
        remove(node);
        // add to the tail
        addTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        addTail(node);
        map.put(key, node);
        if (map.size() > capacity){
            map.remove(head.nxt.key);
            remove(head.nxt);
        }
    }

    public void remove(Node node){
        node.pre.nxt = node.nxt;
        node.nxt.pre = node.pre;
    }

    public void addTail(Node node){
        tail.pre.nxt = node;
        node.pre = tail.pre;
        node.nxt = tail;
        tail.pre = node;
    }
}

class Node{
    Node pre;
    Node nxt;
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
