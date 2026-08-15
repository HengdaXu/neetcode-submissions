class Solution {
    public int majorityElement(int[] nums) {
        int major = 0, res = -1;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > major){
                major = count.get(num);
                res = num;
            }
        }
        return res;
    }
}