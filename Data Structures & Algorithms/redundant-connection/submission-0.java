class Solution {
    public int[] findRedundantConnection(int[][] edges) {        
        int n = edges.length;
        DisjoinSet ds = new DisjoinSet(n);
        int[] ans = new int[2];
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
                ds.unionBySize(u, v);
            } else {
                ans = edge;
            }
        }

        return ans;
    }
}

class DisjoinSet {
    private int[] parent;
    private int[] size;

    DisjoinSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        init(n);
    }

    private void init(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void unionBySize(int u, int v) {
        int ulpU = findUltimateParent(u);
        int ulpV = findUltimateParent(v);

        if (ulpU == ulpV) return;

        if (size[ulpU] < size[ulpV]) {
            parent[ulpU] = ulpV;
            size[ulpV] += size[ulpU];
        } else {
            parent[ulpV] = ulpU;
            size[ulpU] += size[ulpV];
        }
    }

    public int findUltimateParent(int node) {
        if (parent[node] == node)
            return node;

        int ultimateParent = findUltimateParent(parent[node]);
        parent[node] = ultimateParent;
        return ultimateParent;
    }
}
