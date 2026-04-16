class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //[1, 2, 2, 3, 3, 4, 4, 5]
        Arrays.sort(hand);
        int max = Arrays.stream(hand).max().getAsInt();
        int[] map = new int[max + 1];

        for (int num: hand){
            map[num]++;
        }

        for (int card : hand) {
            if (map[card] > 0) {
                // Try to form a group starting from this card
                for (int j = card; j < card + groupSize; j++) {
                    if (j >= map.length || map[j] == 0) return false;
                    map[j]--;
                }
            }
        }
        return true;
    }
}
