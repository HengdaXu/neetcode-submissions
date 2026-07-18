class Solution {
    public int climbStairs(int n) {
        int first = 1, second = 2;
        if (n <= 2) return n;

        for (int i = 3; i <= n; i++){
            int tmp = second;
            second = first + second;
            first = tmp;
        }

        return second;

    }
}
