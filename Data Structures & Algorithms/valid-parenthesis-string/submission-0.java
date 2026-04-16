class Solution {
    public boolean checkValidString(String s) {
        int leftmin = 0, leftmax = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                leftmin++;
                leftmax++;
            }else if (s.charAt(i) == ')'){
                leftmin--;
                leftmax--;
            }else{
                leftmin--;
                leftmax++;
            }
            if (leftmax < 0) return false;
            if (leftmin < 0) leftmin = 0;
        }
        return leftmin == 0;
    }
}
