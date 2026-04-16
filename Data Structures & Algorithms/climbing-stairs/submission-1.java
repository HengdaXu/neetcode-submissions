class Solution {
    int count;

    public int climbStairs(int n) {
        count = 0;

        rec(0, n);
        return count;
        
    }
    private void rec(int i, int n){
        if (i > n) return;
        if (i == n) {
            count++;
            return;
        }


        rec(i+1, n);
        rec(i+2, n);
    }
}
