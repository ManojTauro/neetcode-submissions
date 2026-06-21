class Solution {
    // to make a graph a valid tree
    // 1. Should not have cycle
    // 2. Should have only one component
    
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        createAdj(n, edges);

        Set<Integer> vis = new HashSet<>();

        if (!dfs(0, -1, vis)) return false;

        return vis.size() == n;
    }

    // return false if there is a cycle
    private boolean dfs(int node, int parent, Set<Integer> vis) {
        vis.add(node);

        for (int adjNode: adj.get(node)) {
            if (!vis.contains(adjNode)) {
                if (!dfs(adjNode, node, vis)) return false;
            } else if (parent != adjNode) {
                return false;
            }
        }

        // no cycle
        return true;
    }

    private void createAdj(int n, int[][] edges) {
        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}
