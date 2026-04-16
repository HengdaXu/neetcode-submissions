class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r){
            int k = (l + r)/2;
            long total = 0;
            for (int pile: piles){
                total += Math.ceil((double)pile/k);
            }

            if (total <= h){
                res = k;
                r = k - 1;
            }else{
                l = k + 1;
            }
        }
        return res;
    }
}
