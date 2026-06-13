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
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean solve(TreeNode root, int lb, int ub) {
        if (root == null) return true;

        if (root.val <= lb) return false;

        if (root.val >= ub) return false;

        return solve(root.left, lb, root.val) && solve(root.right, root.val, ub);
    }
}
