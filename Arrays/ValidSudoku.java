class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char num = board[row][col];

                if (num == '.') {
                    continue;
                }

                // Row
                String rowKey = num + " in row " + row;

                // Column
                String colKey = num + " in col " + col;

                // 3 x 3 box
                String boxKey = num + " in box " + (row / 3) + "-" + (col / 3);

                // If duplicate found
                if (!set.add(rowKey) ||
                    !set.add(colKey) ||
                    !set.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}
