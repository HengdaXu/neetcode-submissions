class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int l = 0;
        int res = 0, total = 0;
        for (int r = 0; r < fruits.length; r++){
            freq.put(fruits[r], freq.getOrDefault(fruits[r], 0) + 1);
            total++;

            while (freq.size() > 2){
                freq.put(fruits[l], freq.get(fruits[l]) - 1);
                if (freq.get(fruits[l]).equals(0)) freq.remove(fruits[l]);
                l++;
                total--;
            }
            

            res = Math.max(res, total);
        }  
        return res; 
    }
}