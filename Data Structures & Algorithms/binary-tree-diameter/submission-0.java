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
        int[] maxDiameter = new int[1];

        depth(root, maxDiameter);

        return maxDiameter[0];
    }

    private int depth(TreeNode root, int[] maxD) {
        if (root == null) return 0;

        int lh = depth(root.left, maxD);
        int rh = depth(root.right, maxD);

        maxD[0] = Math.max(maxD[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
