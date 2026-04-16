class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int [nums.length - k + 1];
        PriorityQueue<int[]> maxH = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            maxH.add(new int[]{nums[i], i});
            if (i + 1 >= k){
                while (maxH.peek()[1] < (i + 1 - k)){
                    maxH.poll();
                }
                res[index++] = maxH.peek()[0];
            }
        }
        return res;
    }
}
