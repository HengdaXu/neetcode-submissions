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
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node == null){
                res.append("N,");
            }else{
                res.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(head);
        int index = 1;

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (!vals[index].equals("N")){
                node.left = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(node.left);
            }
            index++;
            if (!vals[index].equals("N")){
                node.right = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(node.right);
            }
            index++;
        }
        return head;  
    }
}
