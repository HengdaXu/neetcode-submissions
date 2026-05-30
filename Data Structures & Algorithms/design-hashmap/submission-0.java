class Node{
    int key;
    int value;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    private Node[] map;
    private int size;

    public MyHashMap() {
        this.size = 100007;
        this.map = new Node[this.size];
    }

    public int hash(int key){
        return key % this.size;
    }
    
    public void put(int key, int value) {
        remove(key);
        int k = hash(key);
        Node n = new Node(key, value);
        n.next = map[k];
        map[k] = n;
        return;
    }
    
    public int get(int key) {
        int k = hash(key);
        if (map[k] == null) return -1;
        Node n = map[k];
        while (n != null){
            if (n.key == key) return n.value;
            n = n.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int k = hash(key);
        if (map[k] == null) return;
        Node n = map[k];
        if (n.key == key){
            map[k] = n.next;
            return;
        }
        while (n.next != null){
            if (n.next.key == key){
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */