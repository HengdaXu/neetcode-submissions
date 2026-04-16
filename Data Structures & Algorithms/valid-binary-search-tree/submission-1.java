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
    public boolean isValidBST(TreeNode root) {
        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>();
        q.add(new Pair<>(root, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}));

        while (!q.isEmpty()){
            Pair<TreeNode, int[]> p = q.poll();
            TreeNode node = p.getKey();
            int l = p.getValue()[0], r = p.getValue()[1];

            if (node != null){
                if (node.val <= l || node.val >= r) return false;
                q.add(new Pair<>(node.left, new int[]{l, node.val}));
                q.add(new Pair<>(node.right, new int[]{node.val, r}));
            }
        }
        return true;
    }
}
