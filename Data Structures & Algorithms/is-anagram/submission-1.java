class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] countS = new int[26];
        for (int i=0; i < s.length(); i++){
            countS[s.charAt(i) - 'a']++;
            countS[t.charAt(i) - 'a']--;
        }

        for (int c: countS){
            if (c != 0){
                return false;
            }
        }

        return true;
        
    }
}
