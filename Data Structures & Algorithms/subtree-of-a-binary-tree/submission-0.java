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
    // we can resuse the isSameTree fn.
    // For each node in the org tree call the isSameTree fn
    // if isSameTree fn return true then retunr true
    // else recurse on left and right subtree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // edge cases
        // if root and subRoot is null then return True
        // if root is not null and subRoot is null - return True
        // if root is null and subRoot is not null - return false

        if (root == null && subRoot == null) return true;

        if (root != null && subRoot == null) return true;

        if (root == null && subRoot != null) return false;

        if (isSameTree(root, subRoot)) return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right);
    }
}
