class Solution {
    List<String> res;
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs("", digits, 0);
        return res;  
    }

    private void dfs(String cur, String digits, int i){
        if (i >= digits.length()){
            res.add(cur);
            return;
        }

        String chars = map[digits.charAt(i) - '0'];
        for (char c: chars.toCharArray()){
            dfs(cur + c, digits, i + 1);
        }
    }
}
