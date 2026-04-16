class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            heap.add(new int[]{nums[i], i});
            
            while (heap.peek()[1] <= i - k){
                heap.poll();
            }
                
            if (i >= k - 1) res[index++] = heap.peek()[0];
            
        }
        return res;
    }
}
