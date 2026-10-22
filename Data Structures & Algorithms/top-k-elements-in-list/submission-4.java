class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++){
            freq[i] = new ArrayList<>();
        }
        

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);   
        }

        count.forEach((key, value) -> {
            freq[value].add(key);
        });


        int[] res = new int[k--];
        for (int i = nums.length; i >= 0; i--){
            if (freq[i].size() == 0) continue;
            for (int n: freq[i]){
                if (k < 0) break;
                res[k--] = n;
            }
        }
        return res;  
    }
}
