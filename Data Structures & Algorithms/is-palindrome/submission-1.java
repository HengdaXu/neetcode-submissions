class Solution {
    public boolean isPalindrome(String s) {
         String result = s.replaceAll("[^a-zA-Z0-9]", "");
         result = result.toLowerCase();
         System.out.println(result);
         int i = 0, j = result.length() - 1;
         while (i < j){
            if (result.charAt(i) == result.charAt(j)){
                i++; j--;
            }else{
                return false;
            }
         }
         return true;
    }
}
