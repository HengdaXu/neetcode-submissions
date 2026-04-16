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

class Solution {
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        if (root == null) return true;
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)){
                stack.push(node.left);
            }else if (node.right != null && !map.containsKey(node.right)){
                stack.push(node.right);
            }else{
                node = stack.pop();

                int left = map.get(node.left);
                int right = map.get(node.right);
                if (Math.abs(left - right) > 1) return false;
                map.put(node, 1 + Math.max(left, right));
            }
        }
        return true;
    }
}
