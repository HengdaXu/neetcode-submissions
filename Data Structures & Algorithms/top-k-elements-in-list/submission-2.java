class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, List<Integer>> bucket = new HashMap<>();
        count.forEach((key, value) -> {
            bucket.putIfAbsent(value, new ArrayList<>());
            bucket.get(value).add(key);
        });

        int[] res = new int[k];
        int index = 0;
        int maxFreq = nums.length;
        while (k > 0){
            if (bucket.containsKey(maxFreq)){
                for (int num: bucket.get(maxFreq)){
                    res[index++] = num;
                    k--;
                }
            }

            maxFreq--;
        }
        return res;
    }
}
