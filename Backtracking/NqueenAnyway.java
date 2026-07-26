import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueen(board, 0, ans);

        return ans;
    }

    // Backtracking function
    private void nQueen(char[][] board, int row, List<List<String>> ans) {

        // Base case
        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        // Try placing queen in every column
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                nQueen(board, row + 1, ans);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }

    // Check if queen can be placed
    private boolean isSafe(char[][] board, int row, int col) {

        // Vertical Up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Left Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Right Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    // Convert board into List<String>
    private List<String> construct(char[][] board) {

        List<String> temp = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            temp.add(new String(board[i]));
        }

        return temp;
    }
}
