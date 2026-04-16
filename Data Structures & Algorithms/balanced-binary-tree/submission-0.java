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
        if (root == null) return true;
        HashMap<TreeNode, Integer> mp = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        mp.put(null, 0);
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node.right != null && !mp.containsKey(node.right)){
                stack.push(node.right);
            }else if (node.left != null && !mp.containsKey(node.left)){
                stack.push(node.left);
            }else{
                node = stack.pop();
                
                int lh = mp.get(node.left), rh = mp.get(node.right);
                if (rh - lh > 1 || rh - lh < -1){
                    return false;
                }
                int height = Math.max(lh, rh) + 1;
                mp.put(node, height);
            }
        }
        return true;
    }
}
