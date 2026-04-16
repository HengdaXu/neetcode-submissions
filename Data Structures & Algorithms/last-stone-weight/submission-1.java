class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int num: stones){
            maxHeap.offer(num);
        }

        while (maxHeap.size() > 1){
            int x = maxHeap.poll(), y = maxHeap.poll();
            if (x == y) continue;
            if (x < y){
                maxHeap.offer(y - x);
            }else{
                maxHeap.offer(x - y);
            }
        }

        return (maxHeap.size() == 1) ? maxHeap.poll() : 0;


    }
}
