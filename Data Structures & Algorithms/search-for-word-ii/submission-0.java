class Solution {
    List<String> res;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        res = new ArrayList<>();
        Node root = new Node();
        for (int i = 0; i < words.length; i++){
            root.addWord(words[i], i);
        }

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                dfs(board, root, r, c, words);
            }
        }
        return res;


    }

    private void dfs(char[][]board, Node node, int r, int c, String[] words){
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] == '*' || node.next[board[r][c] - 'a'] == null) return;

        char tmp = board[r][c];
        board[r][c] = '*';
        Node prev = node;
        node = node.next[tmp - 'a'];
        if (node.idx != -1){
            res.add(words[node.idx]);
            node.ref--;
            node.idx = -1;
            if (node.ref == 0){
                node = null;
                prev.next[tmp - 'a'] = null;
                board[r][c] = tmp;
                return;
            }
        }

        for (int[] dir: directions){
            int nr = r + dir[0], nc = c + dir[1];
            dfs(board, node, nr, nc, words);
        }
        board[r][c] = tmp;
        return;
    }
}

class Node {
    Node[] next;
    int idx;
    int ref;

    public Node(){
        next = new Node[26];
        idx = -1;
        ref = 0;
    }

    public void addWord(String word, int i){
        Node cur = this;
        cur.ref++;
        for (char c: word.toCharArray()){
            if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
            cur = cur.next[c - 'a'];
            cur.ref++;
        }
        cur.idx = i;
    }
}
