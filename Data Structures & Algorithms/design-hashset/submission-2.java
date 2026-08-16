class MyHashSet {
    private Node[] set;

    public MyHashSet() {
        set = new Node[1000000];
    }
    
    public void add(int key) {
        Node n = set[key%set.length];
        if (n == null){
            set[key%set.length] = new Node(key);
            return;
        }
        if (n.key == key) return;
        while (n.next != null){
            if (n.next.key == key) return;
            n = n.next;
        }
        n.next = new Node(key);
    }
    
    public void remove(int key) {
        Node n = set[key%set.length];
        if (n == null) return;
        if (n.key == key){
            set[key%set.length] = n.next;
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
    
    public boolean contains(int key) {
        Node n = set[key%set.length];
        while (n != null){
            if (n.key == key) return true;
            n = n.next;
        }
        return false;
    }
}

class Node{
    private Node next;
    private int key;

    public Node(int key){
        this.key = key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */