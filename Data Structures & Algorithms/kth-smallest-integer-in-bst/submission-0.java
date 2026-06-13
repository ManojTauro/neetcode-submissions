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
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        solve(root, new int[1], k);

        return result;
    }

    private void solve(TreeNode root, int[] count, int k) {
        if (root == null) return;

        solve(root.left, count, k);
        count[0] += 1;

        if (count[0] == k) {
            result = root.val;
            return;
        }

        solve(root.right, count, k);
    }
}
