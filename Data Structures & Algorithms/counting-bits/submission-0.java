class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++){
            int count = 0;
            for (int j = 0; j < 10; j++){
                if (((1 << j) & i) > 0){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
