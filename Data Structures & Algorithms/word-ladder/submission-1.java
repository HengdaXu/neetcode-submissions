class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String word: wordList){
            words.add(word);
        }
        if (!words.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 1;
        while (!q.isEmpty()){
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++){
                String curr = q.poll();
                for (int j = 0; j < curr.length(); j++){
                    for (int c = 0; c < 26; c++){
                        String sub = curr.substring(0, j) + (char)('a' + c) + curr.substring(j + 1);
                        if (sub.equals(endWord)) return res;
                        if (words.contains(sub)){
                            q.offer(sub);
                            words.remove(sub);
                            
                        }
                    }
                }
            }
        }
        return 0;
    }
}
