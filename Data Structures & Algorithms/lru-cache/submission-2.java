class LRUCache {
    private Deque<Integer> deque;
    private HashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.deque = new ArrayDeque<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        deque.remove(key);
        deque.offerLast(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            deque.remove(key);
        }
        deque.offerLast(key);
        map.put(key, value);
        if (map.size() > capacity){
            map.remove(deque.pollFirst());
        }
    }
}
