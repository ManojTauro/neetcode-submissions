class Solution {
    public boolean isValidSudoku(char[][] board) {
        // use hashset to add numbers for each row, col and box
        // when adding if that number is already there then return false

        int n = board.length;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxes[i] = new HashSet();
        }

        // update sets with numbers from input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;

                if (rows[i].add(board[i][j]) == false) return false;
                if (cols[j].add(board[i][j]) == false) return false;

                // idx = (row / 3) * 3 + col / 3
                int boxIdx = (i / 3) * 3 + j / 3;
                if (boxes[boxIdx].add(board[i][j]) == false) return false;
            }
        }

        return true;
    }
}
