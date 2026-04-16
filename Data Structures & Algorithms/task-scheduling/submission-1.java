class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task: tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int fre: count){
            if (fre > 0) maxHeap.offer(fre);
        }

        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;

            if (maxHeap.isEmpty()){
                time = cooldown.peek()[1];
            }else{
                int f = maxHeap.poll() - 1;
                if (f > 0) cooldown.offer(new int[]{f, time + n});
            }

            if (!cooldown.isEmpty() && cooldown.peek()[1] == time){
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;

    }
}
