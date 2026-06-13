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
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;

        solve(root, max);

        return max[0];   
    }

    private int solve(TreeNode root, int[] max) {
        if (root == null) return 0;

        int leftAns = Math.max(0, solve(root.left, max));
        int rightAns = Math.max(0, solve(root.right, max));

        max[0] = Math.max(max[0], root.val + leftAns + rightAns);

        return root.val + Math.max(leftAns, rightAns);
    }
}
