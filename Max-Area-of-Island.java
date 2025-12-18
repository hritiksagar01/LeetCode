1class Solution {
2    public int maxAreaOfIsland(int[][] grid) {
3        int row = grid.length;
4        int col = grid[0].length;
5
6        boolean[][] vis = new boolean[row][col];
7        int[] delrow = {-1, 0, 1, 0};
8        int[] delcol = {0, 1, 0, -1};
9
10        int maxArea = 0;
11
12        for (int i = 0; i < row; i++) {
13            for (int j = 0; j < col; j++) {
14                if (!vis[i][j] && grid[i][j] == 1) {
15                    int area = dfs(i, j, vis, grid, delrow, delcol);
16                    maxArea = Math.max(maxArea, area);
17                }
18            }
19        }
20        return maxArea;
21    }
22
23    private int dfs(int r, int c, boolean[][] vis,
24                    int[][] grid, int[] dr, int[] dc) {
25
26        vis[r][c] = true;
27        int area = 1;
28
29        for (int k = 0; k < 4; k++) {
30            int nr = r + dr[k];
31            int nc = c + dc[k];
32
33            if (nr >= 0 && nr < grid.length &&
34                nc >= 0 && nc < grid[0].length &&
35                !vis[nr][nc] && grid[nr][nc] == 1) {
36
37                area += dfs(nr, nc, vis, grid, dr, dc);
38            }
39        }
40        return area;
41    }
42}
43