class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= nums.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = bucket.length - 1; i >= 0; i--){
            for (int num: bucket[i]){
                res[index++] = num;
                if (index == k) return res;
            }
        }
        return res;
    }
}
