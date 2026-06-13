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
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(in[i], i);

        return solve(pre, 0, n - 1, in, 0, n - 1, map);
    }

    // ps - preStart
    // pe - preEnd
    // is - inStart
    // ie - inEnd
    private TreeNode solve(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;

        int rootNodeVal = pre[ps];
        TreeNode root = new TreeNode(rootNodeVal);

        int inRoot = map.get(rootNodeVal);
        int elementsInLeft = inRoot - is;

        root.left = solve(pre, ps + 1, ps + elementsInLeft, in, is, inRoot - 1, map);
        root.right = solve(pre, ps + elementsInLeft + 1, pe, in, inRoot + 1, ie, map);

        return root;
    }
}
