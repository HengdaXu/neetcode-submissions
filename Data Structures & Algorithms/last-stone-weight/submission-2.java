class Solution {
    public int lastStoneWeight(int[] stones) {
        int size = 0;
        for (int stone: stones){
            size = Math.max(size, stone);
        }

        int[] bucket = new int[size + 1];
        for (int stone: stones){
            bucket[stone]++;
        }

        int first = size, second = size;
        while (first > 0){
            if (bucket[first] % 2 == 0){
                first--;
                continue;
            }

            int j = Math.min(first - 1, second);
            while (j > 0 && bucket[j] == 0){
                j--;
            }

            if (j == 0) return first;

            second = j;
            bucket[first]--;
            bucket[second]--;
            bucket[first - second]++;
            first = Math.max(first - second, second);
        }
        return first;
    }
}
