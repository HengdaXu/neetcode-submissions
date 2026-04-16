class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (j < str.length() && str.charAt(j) != '#') j++;

            if (j == str.length()) break; // 没有找到 '#'，格式错误

            int len = Integer.parseInt(str.substring(i, j));
            if (j + 1 + len > str.length()) break; // 防止越界

            String word = str.substring(j + 1, j + 1 + len);
            res.add(word);
            i = j + 1 + len;
        }
        return res;
    }
}
