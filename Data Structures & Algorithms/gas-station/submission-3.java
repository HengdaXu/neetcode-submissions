class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasS = Arrays.stream(gas).sum();
        int costS = Arrays.stream(cost).sum();
        
        if (gasS < costS) return -1;
        
        int acc = 0, res = 0;
        for (int i = 0; i < gas.length; i++){
            acc += (gas[i] - cost[i]);
            if (acc < 0){
                acc = 0;
                res = (i + 1 < gas.length) ? i + 1: -1;
            }
        }

        return res;
    }
}
