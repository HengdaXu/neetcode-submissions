class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1, count = people.length;
        int res = 0;
        while (l < r){
            if (people[l] + people[r] <= limit){
                l++;
                r--;
                count -= 2;
            }else{
                r--;
                count -= 1;
            }
            res++;
        }
        
        return res + count;
    }
}