class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()){
            return false;
        }
        int[] p1 = new int[26];
        for (char c: s1.toCharArray()){
            p1[c - 'a']++;
        }

        for (int r = 0; r < s2.length() - s1.length() + 1; r++){
            int l = r + s1.length();
            int[] p2 = new int[26];
            for (char c: s2.substring(r, l).toCharArray()){
                p2[c - 'a']++;
            }
            if (Arrays.equals(p1, p2)){
                return true;
            }
        }
        
        return false;
    }
}
