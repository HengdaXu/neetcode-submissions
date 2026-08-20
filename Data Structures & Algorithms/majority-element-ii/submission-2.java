class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1, c2, f1, f2;
        c1 = c2 = nums[0]; f1 = 1; f2 = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != c1 && nums[i] != c2){
                if (f1 == 0){
                    c1 = nums[i];
                    f1 = 1;
                    continue;
                }else if (f2 == 0){
                    c2 = nums[i];
                    f2 = 1;
                    continue;
                }else{
                    f1--;
                    f2--;
                }
            }else{
                f1 += (nums[i] == c1) ? 1 : 0;
                if (c1 != c2){
                    f2 += (nums[i] == c2) ? 1 : 0;
                }
                
            }
        }

        f1 = f2 = 0;
        for (int num: nums){
            if (num == c1){
                f1++;
            }else if (num == c2){
                f2++;
            }
        }

        System.out.println(c1 + ": " + f1);
        System.out.println(c2 + ": " + f2);
        if (f1 > nums.length/3) res.add(c1);
        if (f2 > nums.length/3) res.add(c2);
        return res;
    }
}