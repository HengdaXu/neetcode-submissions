class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] cur = new int[]{1, 1, 1};
        for (int[] t: triplets){
            if (t[0] < target[0] && t[1] < target[1] && t[2] < target[2]) continue;
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            cur[0] = Math.max(t[0], cur[0]);
            System.out.println(cur[0]);
            cur[1] = Math.max(t[1], cur[1]);
            System.out.println(cur[1]);
            cur[2] = Math.max(t[2], cur[2]);
            System.out.println(cur[2]);
            if (cur[0] == target[0] && cur[1] == target[1] && cur[2] == target[2]) return true;
        }

        return false;
    }
}
