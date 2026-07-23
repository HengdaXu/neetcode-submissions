class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            add(n, key);
            return n.val;
        }
        return -1;

    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        add(node, key);
        if (map.size() > capacity){
            remove(head.next);
        }
    }

    public void remove(Node n){
        Node pre = n.pre;
        Node next = n.next;
        pre.next = next;
        next.pre = pre;
        map.remove(n.key);
    }

    public void add(Node n, int key){
        Node tmp = tail.pre;
        tmp.next = n;
        n.pre = tmp;
        n.next = tail;
        tail.pre = n;
        map.put(key, n);
    }
}

public class Node{
    int key;
    int val;
    Node pre;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}
