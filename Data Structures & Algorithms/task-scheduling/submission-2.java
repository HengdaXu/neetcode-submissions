class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task: tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < 26; i++){
            if (count[i] != 0) maxHeap.offer(count[i]);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if (!maxHeap.isEmpty()){
                int cfreq = maxHeap.poll() - 1;
                if (cfreq > 0) q.offer(new int[]{cfreq, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time){
                maxHeap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
