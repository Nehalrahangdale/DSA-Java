class Solution {

    public int uniquePaths(int m, int n) {
        return backtrack(0, 0, m, n);
    }

    public int backtrack(int i, int j, int m, int n) {

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Outside the grid
        if (i >= m || j >= n) {
            return 0;
        }

        // Explore both choices
        int down = backtrack(i + 1, j, m, n);
        int right = backtrack(i, j + 1, m, n);

        return down + right;
    }
}
