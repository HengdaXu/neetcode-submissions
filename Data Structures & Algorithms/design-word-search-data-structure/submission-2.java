class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (cur.children[index] == null) cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode root){
        TrieNode cur = root;

        for (int j = i; j < word.length(); j++){
            char c = word.charAt(j);
            if (c == '.'){
                for (TrieNode child: cur.children){
                    if (child != null && dfs(word, j + 1, child)) return true;
                }
                return false;
            }else{
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
        }
        return cur.word;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean word;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.word = false;
    }
}
