1class Solution {
2    public int numIslands(char[][] grid) {
3        int n = grid.length;        // rows
4        int m = grid[0].length;     // columns
5
6        int[][] vis = new int[n][m];
7        int count = 0;
8
9        for (int i = 0; i < n; i++) {          // row
10            for (int j = 0; j < m; j++) {      // col
11                if (grid[i][j] == '1' && vis[i][j] == 0) {
12                    count++;
13                    dfs(i, j, vis, grid);
14                }
15            }
16        }
17        return count;
18    }
19
20    private void dfs(int row, int col, int[][] vis, char[][] grid) {
21        vis[row][col] = 1;
22
23        int n = grid.length;
24        int m = grid[0].length;
25
26        int[] delRow = {-1, 0, 1, 0};
27        int[] delCol = {0, 1, 0, -1};
28
29        for (int i = 0; i < 4; i++) {
30            int nrow = row + delRow[i];
31            int ncol = col + delCol[i];
32
33            if (nrow >= 0 && nrow < n &&
34                ncol >= 0 && ncol < m &&
35                vis[nrow][ncol] == 0 &&
36                grid[nrow][ncol] == '1') {
37
38                dfs(nrow, ncol, vis, grid);
39            }
40        }
41    }
42}
43