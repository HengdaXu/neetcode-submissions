class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            Node n = cache.get(key);
            Node tmp = n.prev;
            tmp.next = n.next;
            n.next.prev = tmp;

            Node p = right.prev;
            p.next = n;
            n.prev = p;
            n.next = right;
            right.prev = n;
            return n.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node old = cache.get(key);
            Node tmp = old.prev;
            tmp.next = old.next;
            tmp.next.prev = tmp;
        }
        Node newN = new Node(key, value);
        cache.put(key, newN);
        Node p = this.right.prev;
        p.next = newN;
        newN.prev = p;
        newN.next = this.right;
        this.right.prev = newN;

        if (cache.size() > cap){
            Node n = this.left.next;
            this.left.next = n.next;
            n.next.prev = this.left;
            cache.remove(n.key);
        }
        
    }
}

public class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
