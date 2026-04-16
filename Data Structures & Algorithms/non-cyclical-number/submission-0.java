class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1){
            n = happy(n);
            if (set.contains(n)) return false;
            set.add(n);
            System.out.println(n);
        }
        return true;
        
    }

    private int happy(int n){
        int res = 0;
        while (n > 0){
            res += Math.pow((n % 10), 2);
            n /= 10;
        }
        return res;
    }
}
