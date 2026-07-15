class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> dup = new HashSet<>();

        if (s.length() == 0) return 0;

        int i = 0, maxSub = 1, currSub = 1;
        dup.add(s.charAt(i));
        for (int j = 1; j < s.length(); j++){
            char c = s.charAt(j);
            while (dup.contains(c)){
                dup.remove(s.charAt(i++));
                currSub--;
            }
            dup.add(c);
            currSub++;
            maxSub = Math.max(currSub, maxSub);
        }
        return maxSub;
    }
}
