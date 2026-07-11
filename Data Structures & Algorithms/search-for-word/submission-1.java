class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, 0, board, word, vis)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int index, char[][] board, String word, boolean[][] vis) {
        int m = board.length;
        int n = board[0].length;

        if (index == word.length() - 1) return true;

        vis[i][j] = true;

        for (int[] dir: dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
        
            if (!isValid(ni, nj, m, n)) continue;

            if (vis[ni][nj]) continue;

            if (word.charAt(index + 1) != board[ni][nj]) continue;

            if (dfs(ni, nj, index + 1, board, word, vis)) return true;
        }

        vis[i][j] = false;

        return false;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
