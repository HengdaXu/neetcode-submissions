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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, int[]> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        map.put(null, new int[]{0, 0});

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)){
                stack.push(node.left);
            }else if (node.right != null && !map.containsKey(node.right)){
                stack.push(node.right);
            }else{
                node = stack.pop();

                int[] left = map.get(node.left);
                int[] right = map.get(node.right);

                int leftD = left[0], leftH = left[1];
                int rightD = right[0], rightH = right[1];
                int height = 1 + Math.max(leftH, rightH);
                int diameter = Math.max(leftH + rightH, Math.max(leftD, rightD));
                map.put(node, new int[]{diameter, height});
            }
        }
        return map.get(root)[0];
    }
}
