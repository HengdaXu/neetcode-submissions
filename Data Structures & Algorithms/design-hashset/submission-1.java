class MyHashSet {
    private int[] set;
    private int size;

    public MyHashSet() {
        set = new int[100007];
        size = 100007;
        Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        int h = hash(key);
        set[h] = key;
    }
    
    public void remove(int key) {
        int h = hash(key);
        set[h] = -1;
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        if (set[h] != -1) return true;
        return false;
    }

    public int hash(int key){
        return key % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */