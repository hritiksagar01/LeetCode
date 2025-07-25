class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        // 1. Mark all 'O's connected to the border as safe.
        // We do this by starting a DFS from each 'O' on the border.

        // Check top and bottom rows
        for (int j = 0; j < m; j++) {
            // Top row
            if (board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, vis, board, n, m);
            }
            // Bottom row
            if (board[n - 1][j] == 'O' && vis[n - 1][j] == 0) {
                dfs(n - 1, j, vis, board, n, m);
            }
        }

        // Check left and right columns
        for (int i = 0; i < n; i++) {
            // Left column
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, vis, board, n, m);
            }
            // Right column
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0) {
                dfs(i, m - 1, vis, board, n, m);
            }
        }

        // 2. Flip all remaining 'O's to 'X's.
        // Any 'O' that was not visited by the DFS must be surrounded.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // DFS to find all 'O's connected to a starting point
    private void dfs(int row, int col, int[][] vis, char[][] board, int n, int m) {
        // Base cases for stopping the recursion
        if (row < 0 || row >= n || col < 0 || col >= m || vis[row][col] == 1 || board[row][col] == 'X') {
            return;
        }

        // Mark the current cell as visited (safe)
        vis[row][col] = 1;

        // Explore all 4 adjacent cells
        dfs(row + 1, col, vis, board, n, m);
        dfs(row - 1, col, vis, board, n, m);
        dfs(row, col + 1, vis, board, n, m);
        dfs(row, col - 1, vis, board, n, m);
    }
}