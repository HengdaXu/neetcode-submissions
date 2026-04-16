class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c: tasks){
            count[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i: count){
            if (i > 0) maxHeap.add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if (!maxHeap.isEmpty()){
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) q.add(new int[]{cnt, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
        
    }
}
