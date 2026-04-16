class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(s, cur, 0);
        return res;

    }

    private void dfs(String s, List<String> cur, int i){
        if (i >= s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < s.length(); j++){
            if (isPali(s, i, j)){
                cur.add(s.substring(i, j + 1));
                dfs(s, cur, j + 1);
                cur.remove(cur.size() - 1);
            }
        }

    }

    private boolean isPali(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
