class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = Arrays.stream(gas).sum();
        int costTotal = Arrays.stream(cost).sum();
        if (gasTotal < costTotal) return -1;

        int res = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if (total < 0){
                total = 0;
                res = i + 1;
            }
        }
        return res;
        
    }
}
