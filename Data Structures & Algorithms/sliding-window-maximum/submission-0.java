class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int l = 0, resIndex = 0;
        int[] res = new int[nums.length - k + 1];
        for (int r = 0; r < nums.length; r++){
            maxHeap.offer(new int[]{nums[r], r});

            if (r - l + 1 < k) continue;

            while (maxHeap.peek()[1] < l){
                maxHeap.poll();
            }
            res[resIndex++] = maxHeap.peek()[0];
            l++;
        }
        return res;
    }
}
