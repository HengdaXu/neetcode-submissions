class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //[1, 2, 2, 3, 3, 4, 4, 5]
        Arrays.sort(hand);
        int max = Arrays.stream(hand).max().getAsInt();
        int[] map = new int[max + 1];

        for (int num: hand){
            map[num]++;
        }

        for (int i = 0; i < hand.length; i++){
            int card = hand[i];
            if (map[card] != 0){
                for (int j = card; j <= card + groupSize - 1; j++){
                    if (j >= map.length || map[j] == 0) return false;
                    map[j]--;
                }
            }
        }
        return true;
    }
}
