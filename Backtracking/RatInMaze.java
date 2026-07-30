package Backtracking;

public class RatInMaze {

    static void solve(int maze[][], int row, int col,
                      String path, boolean visited[][]) {

        int n = maze.length;

        // Base Case
        if (row == n - 1 && col == n - 1) {
            System.out.println(path);
            return;
        }

        // Boundary Check
        if (row < 0 || col < 0 || row >= n || col >= n)
            return;

        // Blocked Cell
        if (maze[row][col] == 0)
            return;

        // Already Visited
        if (visited[row][col])
            return;

        // Mark Visited
        visited[row][col] = true;

        // Up
        solve(maze, row - 1, col, path + "U", visited);

        // Down
        solve(maze, row + 1, col, path + "D", visited);

        // Left
        solve(maze, row, col - 1, path + "L", visited);

        // Right
        solve(maze, row, col + 1, path + "R", visited);

        // Backtracking
        visited[row][col] = false;
    }

    public static void main(String args[]) {

        int maze[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };

        boolean visited[][] = new boolean[4][4];

        solve(maze,0,0,"",visited);
    }
}
