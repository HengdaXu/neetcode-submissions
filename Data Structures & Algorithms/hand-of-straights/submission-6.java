class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Arrays.sort(hand);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: hand){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < hand.length; i++){
            if (freq.get(hand[i]) != 0){
                for (int j = 0; j < groupSize; j++){
                    if (freq.getOrDefault(hand[i] + j, 0) == 0) return false;
                    freq.put(hand[i] + j, freq.get(hand[i] + j) - 1);
                }
            }

        }
        return true; 
    }
}
