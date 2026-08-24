class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int maxWeight = 0;
        for (int weight: people){
            maxWeight = Math.max(maxWeight, weight);
        }

        // Arrays.stream(people).max();
        int[] bucket = new int[maxWeight + 1];
        for (int weight: people){
            bucket[weight]++;
        }

        int res = 0;
        int l = 0, r = bucket.length - 1;
        while (l <= r){
            while (l <= r && bucket[l] == 0){
                l++;
            }
            while (l <= r && bucket[r] == 0){
                r--;
            }
            if (r < l) break;
            res++;
            bucket[r]--;
            if (r + l <= limit & bucket[l] > 0) bucket[l]--;  
        }
        return res;
    }
}