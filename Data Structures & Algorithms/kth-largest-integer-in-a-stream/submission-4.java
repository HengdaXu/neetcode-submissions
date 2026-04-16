class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num: nums){
            minHeap.offer(num);
        }

        while (minHeap.size() > k){
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
