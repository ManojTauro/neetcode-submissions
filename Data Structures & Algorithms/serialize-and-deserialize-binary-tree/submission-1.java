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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ans.append("#,");
                continue;
            }
            ans.append(node.val + ",");
            q.offer(node.left);
            q.offer(node.right);
        }

        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;

        String[] parts = data.split(",");
        int n = parts.length;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int i = 1;
        while (i < parts.length && !q.isEmpty()) {
            TreeNode node = q.poll();

            if (!parts[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                node.left = left;
                q.offer(left);
            }

            i += 1;

            if (!parts[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                node.right = right;
                q.offer(right);
            }

            i += 1;
        }

        return root;
    }
}
