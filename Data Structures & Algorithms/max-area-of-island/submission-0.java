class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        // call dfs on each components (when you see 1)
        // DFS call will recieve a counter and vis array
        // counter is incremented when we reach each cell(1's)
        // counter should be int[1] and then track max value

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    int[] counter = {0};
                    dfs(i, j, grid, vis, counter);
                    maxArea = Math.max(maxArea, counter[0]);
                }
            }
        }

        return maxArea;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] vis, int[] counter) {
        int m = grid.length;
        int n = grid[0].length;

        vis[i][j] = true;
        counter[0] = counter[0] + 1;

        for (int[] dir: dirs) {
            int ni = dir[0] + i;
            int nj = dir[1] + j;

            if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
            if (vis[ni][nj]) continue;
            if (grid[ni][nj] != 1) continue;

            dfs(ni, nj, grid, vis, counter);
        }
    }
}
