class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for (String str: strs){
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            anagrams.put(key, anagrams.getOrDefault(key, new ArrayList<>()));
            anagrams.get(key).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}
