class TimeMap {
    Map<String, List<Pair<String, Integer>>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(value, timestamp));    
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> time = store.getOrDefault(key, new ArrayList<>());
        int l = 0, r = time.size() - 1;
        
        String res = "";
        while (l <= r){
            int m = l + (r - l)/2;
            if (time.get(m).getValue() <= timestamp){
                res = time.get(m).getKey();
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return res;
    }
}

private static class Pair<K, V>{
    private final K key;
    private final V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
