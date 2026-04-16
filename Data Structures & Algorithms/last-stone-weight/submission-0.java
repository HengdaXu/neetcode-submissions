class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones){
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1){
            int s1 = maxHeap.poll(), s2 = maxHeap.poll();
            if (s1 < s2){
                maxHeap.add(s2 - s1);
            }else if (s1 > s2){
                maxHeap.add(s1 - s2);
            }
        }

        if (maxHeap.size() == 1) return maxHeap.peek();
        return 0;
        
    }
}
