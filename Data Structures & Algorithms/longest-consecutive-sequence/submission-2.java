class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> seq = new HashMap<>();

        int res = 0;
        for (int num: nums){
            if (seq.containsKey(num)) continue;
            seq.put(num, seq.getOrDefault(num - 1, 0) + seq.getOrDefault(num + 1, 0) + 1);
            // update left boundary;
            seq.put(num - seq.getOrDefault(num - 1, 0), seq.get(num));
            // update right boundary;
            seq.put(num + seq.getOrDefault(num + 1, 0), seq.get(num));
            res = Math.max(res, seq.get(num));
        }
        return res;
    }
}
