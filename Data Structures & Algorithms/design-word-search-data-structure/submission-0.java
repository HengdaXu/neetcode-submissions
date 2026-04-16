public class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()){
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode root){
        TrieNode cur = root;
        for (int j=i; j < word.length(); j++){
            if (word.charAt(j) == '.'){
                for (TrieNode child: cur.children){
                    if (child != null && dfs(word, j+1, child)){
                        return true;
                    }
                }
                return false;
            }else{
                int idx = word.charAt(j) - 'a';
                if (cur.children[idx] == null) return false;
                cur = cur.children[idx];
            }
        }
        return cur.isEnd;
    }
}
