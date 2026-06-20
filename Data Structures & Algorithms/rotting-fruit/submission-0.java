class Solution {
    record State(int i, int j, int minutes) {}

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<State> q = new ArrayDeque<>();
        int freshFruites = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new State(i, j, 0));
                }

                if (grid[i][j] == 1) {
                    freshFruites += 1;
                }
            }
        }

        int exploredOranges = 0;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int minMinutes = 0;

        while (!q.isEmpty()) {
            State s = q.poll();

            minMinutes = Math.max(minMinutes, s.minutes);

            for (int[] dir: dirs) {
                int ni = s.i + dir[0];
                int nj = s.j + dir[1];

                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;

                if (grid[ni][nj] == 0 || grid[ni][nj] == 2) continue;

                exploredOranges += 1;
                grid[ni][nj] = 2;

                q.offer(new State(ni, nj, s.minutes + 1));
            }
        }

        if (freshFruites != exploredOranges) return -1;

        return minMinutes;
    }
}
