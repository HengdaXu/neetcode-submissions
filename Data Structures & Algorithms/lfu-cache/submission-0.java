class LFUCache {
    private final Map<Integer, Node[]> freq;
    private final Map<Integer, Integer> count;
    private final Map<Integer, Node> map;
    private int capacity;

    public LFUCache(int capacity) {
        this.freq = new HashMap<>();
        this.count = new HashMap<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
        for (int i = 0; i < 200000; i++){
            Node head = new Node(-1, -1);
            Node tail = new Node(-1, -1);
            head.nxt = tail;
            tail.pre = head;
            freq.put(i + 1, new Node[]{head, tail});
            count.put(i + 1, 0);
        }
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        count.put(node.freq, count.get(node.freq) - 1);
        remove(node);
        node.incrementFrequency();
        count.put(node.freq, count.get(node.freq) + 1);
        addToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            count.put(node.freq, count.get(node.freq) - 1);
            remove(node);
            node.incrementFrequency();
            count.put(node.freq, count.get(node.freq) + 1);
            addToTail(node);
            return;
        }
        if (map.size() == capacity){
            for (int i = 1; i <= 200000; i++){
                if (count.get(i) > 0){
                    Node head = freq.get(i)[0];
                    Node deleted = head.nxt;

                    remove(deleted);
                    map.remove(deleted.key);
                    count.put(i, count.get(i) - 1);
                    break;
                }
            }
        }
        Node node = new Node(key, value);
        node.incrementFrequency();
        map.put(key, node);
        count.put(node.freq, count.get(node.freq) + 1);
        addToTail(node);
    }

    public void remove(Node node){
        node.pre.nxt = node.nxt;
        node.nxt.pre = node.pre;
    }

    public void addToTail(Node node){
        Node tail = freq.get(node.freq)[1];
        Node previous = tail.pre;

        previous.nxt = node;
        node.pre = previous;
        node.nxt = tail;
        tail.pre = node;
    }
}

class Node{
    Node pre;
    Node nxt;
    int key;
    int val;
    int freq;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }

    public void incrementFrequency(){
        this.freq++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */