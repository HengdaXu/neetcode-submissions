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
    public int goodNodes(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int res = 0;
        q.add(new Pair<>(root, Integer.MIN_VALUE));

        while (!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            int val = p.getValue();

            if (node != null){
                if (node.val >= val) res++;
                q.add(new Pair<>(node.right, Math.max(node.val, val)));
                q.add(new Pair<>(node.left, Math.max(node.val, val)));
            }
        }
        return res;
        
    }
}
