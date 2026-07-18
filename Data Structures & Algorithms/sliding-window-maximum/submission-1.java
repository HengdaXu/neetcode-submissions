class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];
        int l = 0, resIndex = 0;
        for (int r = 0; r < nums.length; r++){
            while(!window.isEmpty() && nums[window.getLast()] < nums[r]){
                window.removeLast();
            }

            window.addLast(r);

            

            if (window.getFirst() < l) window.removeFirst();
        
            if (r - l + 1 >= k){
                res[resIndex++] = nums[window.getFirst()];
                l++;
            }
            
        }
        return res;

    }
}
