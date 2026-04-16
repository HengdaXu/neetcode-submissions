class KthLargest {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>();
        for (int num: nums){
            add(num);
        } 
    }
    
    public int add(int val) {
        if (minHeap.size() < k){
            minHeap.offer(val);
        }else{
            if (val <= minHeap.peek()){
                maxHeap.offer(val);
            }else{
                maxHeap.offer(minHeap.poll());
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}
