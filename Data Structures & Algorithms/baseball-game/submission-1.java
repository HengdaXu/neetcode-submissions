class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String str: operations){
            switch(str){
                case "D":
                    int num = stack.peek() * 2;
                    stack.push(num);
                    res += num;
                    break;
                case "+":
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    res += n1 + n2;
                    stack.push(n2);
                    stack.push(n1);
                    stack.push(n1 + n2);
                    break;
                case "C":
                    res -= stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    res += stack.peek();
                    break;
            }
        }
        return res;
    }
}