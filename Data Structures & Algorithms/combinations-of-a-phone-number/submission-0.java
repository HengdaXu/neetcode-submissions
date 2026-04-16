class Solution {
    String[] map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits.length() == 0) return res;
        
        dfs(0, digits, "");
        return res;   
    }

    private void dfs(int i, String digits, String curr){
        if (i >= digits.length()){
            res.add(curr);
            return;
        }

        String words = map[digits.charAt(i) - '0'];
        for (int j=0; j < words.length(); j++){
            String temp = curr + words.charAt(j);
            dfs(i+1, digits, temp);
        }
    }
}
