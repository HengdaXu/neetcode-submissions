class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task: tasks){
            count[task - 'A']++;
        }

        Arrays.sort(count);
        int maxf = count[25];
        int slots = (maxf - 1) * n;

        for (int i = 24; i >= 0; i--){
            slots -= Math.min(maxf - 1,  count[i]);
        }

        return Math.max(0, slots) + tasks.length;

    }
}
