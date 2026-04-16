/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsS(root, res);
        return String.join(",", res);
    }

    private void dfsS(TreeNode node, List<String> res){
        if (node == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsS(node.left, res);
        dfsS(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsD(vals, i);
    }

    private TreeNode dfsD(String[] vals, int[] i){
        if (vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[i[0]++]));
        root.left = dfsD(vals, i);
        root.right = dfsD(vals, i);
        return root;
    }
}
