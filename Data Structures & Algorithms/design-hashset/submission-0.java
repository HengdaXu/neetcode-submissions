class Node{
    int key;
    Node next;

    public Node(int key){
        this.key = key;
        this.next = null;
    }
}

class MyHashSet {
    private Node[] set;
    private int size;

    public MyHashSet() {
        this.set = new Node[100007];
        this.size = 100007;
    }

    private int hash(int key){
        return key % this.size;
    }
    
    public void add(int key) {
        if (contains(key)) return;
        int slot = hash(key);
        Node n = new Node(key);
        n.next = set[slot];
        set[slot] = n;
    }
    
    public void remove(int key) {
        int slot = hash(key);
        if (set[slot] == null) return;
        if (set[slot].key == key){
            set[slot] = set[slot].next;
            return;
        }
        Node n = set[slot];
        while (n.next != null){
            if (n.next.key == key){
                n.next = n.next.next;
                break;
            }
            n = n.next;
        }
        return;
    }
    
    public boolean contains(int key) {
        int slot = hash(key);
        if (set[slot] == null) return false;
        Node n = set[slot];
        while (n != null){
            if (n.key == key){
                return true;
            }
            n = n.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */