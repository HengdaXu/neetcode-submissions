class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k >= nums.length) return new int[]{Arrays.stream(nums).max().getAsInt()};

        int[] res = new int[nums.length - k + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int l = 0;
        for (int r = 0; r < nums.length; r++){
            maxHeap.add(nums[r]);
            if (r - l + 1 < k){
                continue;
            }
            if (maxHeap.peek() == nums[l]){
                res[l] = maxHeap.poll();
            }else{
                res[l] = maxHeap.peek();
                maxHeap.remove(nums[l]);
            }
            
            l++;
        }
        return res;
    }
}
