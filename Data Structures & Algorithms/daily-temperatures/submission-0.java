class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i=0; i < temperatures.length; i++){
            if (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    int index = stack.pop();
                    res[index] = i - index;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int index = stack.pop();
            res[index] = 0;
        }
        return res;
    }
}
