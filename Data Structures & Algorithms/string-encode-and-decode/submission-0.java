class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str: strs){
            int len = str.length();
            sb.append(len + "#" + str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res =new ArrayList<>();
        String len = "";
        int i = 0;
        while (i < str.length()){
            if (str.charAt(i) == '#'){
                int l = Integer.parseInt(len);
                res.add(str.substring(++i, i + l));
                len = "";
                i += l;
            }else{
                len += str.charAt(i++);
            }
        }
        return res;
    }
}
