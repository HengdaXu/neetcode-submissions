class Solution {
    public boolean checkValidString(String s) {
        int maxLeft, minLeft;
        maxLeft = minLeft = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                maxLeft++;
                minLeft++;
            }else if (s.charAt(i) == ')'){
                maxLeft--;
                minLeft--;
            }else{
                maxLeft++;
                minLeft--;
            }

            if (maxLeft < 0) return false;
            if (minLeft < 0) minLeft = 0;
        }
        return minLeft == 0;
    }
}
