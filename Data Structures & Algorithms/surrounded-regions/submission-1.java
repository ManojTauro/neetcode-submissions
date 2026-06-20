class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        board[i][j] = 'Y';

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni < 0 || ni >= m || nj < 0 || nj >= n)
                continue;

            if ((board[ni][nj] == 'X') || (board[ni][nj] == 'Y')) continue;

            dfs(board, ni, nj);
        }
    }
}
