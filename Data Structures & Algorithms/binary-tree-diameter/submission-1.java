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
        HashMap<TreeNode, int[]> mp = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        mp.put(null, new int[]{0, 0});
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node.right != null && !mp.containsKey(node.right)){
                stack.push(node.right);
            }else if (node.left != null && !mp.containsKey(node.left)){
                stack.push(node.left);
            }else{
                node = stack.pop();

                int[] leftData = mp.get(node.left);
                int[] rightData = mp.get(node.right);

                int leftLength = leftData[0], leftDiameter = leftData[1];
                int rightLength = rightData[0], rightDiameter = rightData[1];

                int height = 1 + Math.max(leftLength, rightLength);
                int diameter = Math.max(leftLength + rightLength, Math.max(leftDiameter, rightDiameter));

                mp.put(node, new int[]{height, diameter});
            }
        } 
        return mp.get(root)[1];       
    }
}
