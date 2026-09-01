class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();
        HashSet<Character> alpha = new HashSet<>();
        int[] indegree = new int[26];

        if (words.length == 1){
            return words[0];
        }
        for (int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";
            int i1 = 0, i2 = 0;
            while (i1 < word1.length() && i2 < word2.length()){
                char c1 = word1.charAt(i1++), c2 = word2.charAt(i2++);
                alpha.add(c1);
                alpha.add(c2);
                if (c1 != c2){
                    adj.putIfAbsent(c1, new HashSet<>());
                    if (adj.get(c1).add(c2)) {
                        indegree[c2 - 'a']++;
                    }
                    break;
                }
            }
            while (i1 < word1.length()) alpha.add(word1.charAt(i1++));
            while (i2 < word2.length()) alpha.add(word2.charAt(i2++));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int i = 0; i < 26; i++){
            char curr = (char)('a' + i);
            if (indegree[i] == 0 && alpha.contains(curr)) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            char c = (char)(pq.poll() + 'a');
            sb.append(c);

            for (Character nei: adj.getOrDefault(c, new HashSet<>())){
                indegree[nei - 'a']--;
                if (indegree[nei - 'a'] == 0){
                    pq.offer(nei - 'a');
                }
            }
        }
        String res = sb.toString();
        return (res.length() == alpha.size()) ? res : "";
    }
}
