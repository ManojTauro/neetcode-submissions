class Solution {
    // BF - run DFS from each cell and see if it reaches
    // both atlantic(last row or last col) and
    // pacific(1st row or 1st col) - then add it to the result -> (O(m*n) * O(m*n))

    // We know that 1st row and 1st col can reach pacific
    // and last row and last col can reach atlantic
    // so start DFS from these rows and mark which can reach pacific
    // and atlantic. Then at the end run another loop to check
    // which cells reach both and add it to the result

    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificVis = new boolean[m][n];
        boolean[][] atlanticVis = new boolean[m][n];

        // run DFS from first row - Pacific
        for (int j = 0; j < n; j++) {
            // passing prevHeight = heights[i][j] because its allwoed to
            // flow through if height is equal
            dfs(0, j, heights[0][j], heights, pacificVis);
        }

        // run DFS from first col - Pacific
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights[i][0], heights, pacificVis);
        }

        // run DFS from last row - Atlantic
        for (int j = 0; j < n; j++) {
            // passing prevHeight = heights[i][j] because its allwoed to
            // flow through if height is equal
            dfs(m - 1, j, heights[m - 1][j], heights, atlanticVis);
        }

        // run DFS from last col - Atlantic
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights[i][n - 1], heights, atlanticVis);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVis[i][j] && atlanticVis[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int i, int j, int prevHeight, int[][] heights, boolean[][] vis) {
        int m = heights.length;
        int n = heights[0].length;

        vis[i][j] = true;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni < 0 || ni >= m || nj < 0 || nj >= n)
                continue;

            if (vis[ni][nj]) continue;

            // we are flowing from ocean to cells inward
            // so we need to reverse our thinking here
            // where the next cell >= current cell
            if (heights[ni][nj] < heights[i][j]) continue;

            dfs(ni, nj, heights[i][j], heights, vis);
        }
    }
}
