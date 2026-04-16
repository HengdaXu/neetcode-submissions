class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        q.offer(beginWord);
        int res = 0;
        while (!q.isEmpty()){
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                String word = q.poll();
                if (word.equals(endWord)) return res;
                for (int j = 0; j < word.length(); j++){
                    for (char c = 'a'; c <= 'z'; c++){
                        if (word.charAt(j) == c) continue;

                        String con = word.substring(0, j) + c + word.substring(j+1);
                        if (words.contains(con)){
                            q.offer(con);
                            words.remove(con);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
