class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int i, List<String> curr){
        if (i == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < s.length(); j++){
            if (isPali(s.substring(i, j + 1))){
                curr.add(s.substring(i, j + 1));
                dfs(s, j + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPali(String str){
        int l = 0, r = str.length() - 1;
        while (l < r){
            if (str.charAt(l) != str.charAt(r)) return false;
            r--;
            l++;
        }
        return true;
    }
}
