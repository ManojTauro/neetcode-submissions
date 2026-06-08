class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        // we can use the DFS traversal here
        // in a outer for loop whenever you see '1'
        // start a dfs call, also increment a counter 
        // counter represents number of islands.
        // need a vis array to keep track which cells are visited

        int islands = 0;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    islands += 1;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;

        for (int[] dir: dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (!isValid(ni, nj, grid, vis)) continue;

            dfs(ni, nj, grid, vis);
        }
    }

    private boolean isValid(int i, int j, char[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        
        return i >= 0 && i < m && j >= 0 && j < n 
                && !vis[i][j] && grid[i][j] == '1';
    }
}
