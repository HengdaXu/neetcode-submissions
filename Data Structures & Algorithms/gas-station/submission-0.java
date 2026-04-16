class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gSum = Arrays.stream(gas).sum();
        int cSum = Arrays.stream(cost).sum();

        if (gSum < cSum) return -1;

        int res = 0, acc = 0;
        for (int i = 0; i < gas.length; i++){
            acc += gas[i] - cost[i];
            if (acc < 0){
                acc = 0;
                res = (i + 1 < gas.length) ? i + 1 : 0;
            }
        }
        return res;
    }
}
