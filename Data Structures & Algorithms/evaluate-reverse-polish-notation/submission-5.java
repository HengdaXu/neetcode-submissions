class Solution {
    public int evalRPN(String[] tokens) {
        // operations are binary;
        if (tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        
        for (String str: tokens){
            if (set.contains(str)){
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                switch(str){
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = a / b; break;
                }
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
        
    }
}
