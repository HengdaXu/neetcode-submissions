class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        HashSet<Integer> res = new HashSet<>();
        for (int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if (freq.get(num) > n/3) res.add(num);
        }
        return new ArrayList<>(res);
    }
}