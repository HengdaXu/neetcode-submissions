class PrefixTree {
    private Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (cur.next[index] == null) cur.next[index] = new Node();
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (cur.next[index] == null) return false;
            cur = cur.next[index];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c: prefix.toCharArray()){
            int index = c - 'a';
            if (cur.next[index] == null) return false;
            cur = cur.next[index];
        }
        return true;
    }
}

class Node{
    Node[] next;
    boolean isEnd;

    public Node(){
        this.next = new Node[26];
        this.isEnd = false;
    }
}
