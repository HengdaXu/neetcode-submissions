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
        q.offer(new Pair<>(root, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}));

        while (!q.isEmpty()){
            Pair<TreeNode, int[]> pair = q.poll();
            TreeNode node = pair.getKey();
            int[] interval = pair.getValue();

            if (node.val <= interval[0] || node.val >= interval[1]) return false;

            if (node.left != null) q.offer(new Pair<>(node.left, new int[]{interval[0], node.val}));
            if (node.right != null) q.offer(new Pair<>(node.right, new int[]{node.val, interval[1]}));
        }
        return true;
    }
}
