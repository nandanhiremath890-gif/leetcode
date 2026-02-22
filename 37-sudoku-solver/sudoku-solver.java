class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // If cell is empty
                if (board[row][col] == '.') {

                    // Try digits 1-9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursively solve
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }

                    // If no number works, return false
                    return false;
                }
            }
        }

        // If no empty cells left, board is solved
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == num)
                return false;

            // Check column
            if (board[i][col] == num)
                return false;

            // Check 3x3 subgrid
            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;

            if (board[subgridRow][subgridCol] == num)
                return false;
        }

        return true;
    }
}