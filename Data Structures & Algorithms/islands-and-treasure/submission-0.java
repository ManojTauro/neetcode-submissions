class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    record State (int i, int j, int dis) {}

    public void islandsAndTreasure(int[][] grid) {
        Deque<State> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new State(i, j, 0));
                }
            }
        }

        int INF = 2147483647;
        while (!q.isEmpty()) {
            State cur = q.poll();

            for (int[] dir: dirs) {
                int ni = dir[0] + cur.i;
                int nj = dir[1] + cur.j;

                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;

                if (grid[ni][nj] != INF) continue;

                grid[ni][nj] = grid[cur.i][cur.j] + 1;

                q.offer(new State(ni, nj, cur.dis + 1));
            }
        }
    }
}
