class Solution {
    public boolean isValid(String s) {
        if (s.length() <= 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if (stack.isEmpty()) return false;
                char a = stack.pop();
                String par = "" + a + c;
                if (par.equals("()") || par.equals("[]") || par.equals("{}")){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
