class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public int countComponents(int n, int[][] edges) {
        createAdj(n, edges);

        Set<Integer> vis = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                count += 1;
                dfs(i, vis);
            }
        }

        return count;
    }

    private void dfs(int node, Set<Integer> vis) {
        vis.add(node);

        for (int adjNode : adj.get(node)) {
            if (!vis.contains(adjNode)) {
                dfs(adjNode, vis);
            }
        }
    }

    private void createAdj(int n, int[][] edges) {
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}
