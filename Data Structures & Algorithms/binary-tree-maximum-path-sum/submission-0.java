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
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        map.put(null, 0);
        stack.push(root);
        
        int maxValue = Integer.MIN_VALUE;
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)){
                stack.push(node.left);
            }else if (node.right != null && !map.containsKey(node.right)){
                stack.push(node.right);
            }else{
                node = stack.pop();
                int left = Math.max(0, map.get(node.left));
                int right = Math.max(0, map.get(node.right));
                maxValue = Math.max(maxValue, node.val + left + right);

                map.put(node, node.val + Math.max(left, right));
            }
        }
        return maxValue;
    }
}
