class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ana = new HashMap<>();

        for (String word: strs){
            int[] count = new int[26];
            for (int i = 0; i < word.length(); i++){
                count[word.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            ana.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(ana.values());
    }
}
