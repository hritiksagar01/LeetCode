1class Solution {
2    public List<List<Integer>> pacificAtlantic(int[][] heights) {
3
4        int rows = heights.length;
5        int cols = heights[0].length;
6
7        boolean[][] pacific = new boolean[rows][cols];
8        boolean[][] atlantic = new boolean[rows][cols];
9
10        int[] dr = {-1, 0, 1, 0};
11        int[] dc = {0, 1, 0, -1};
12
13        // DFS from Pacific ocean (top row, left column)
14        for (int c = 0; c < cols; c++) {
15            dfs(0, c, heights, pacific, dr, dc);
16        }
17        for (int r = 0; r < rows; r++) {
18            dfs(r, 0, heights, pacific, dr, dc);
19        }
20
21        // DFS from Atlantic ocean (bottom row, right column)
22        for (int c = 0; c < cols; c++) {
23            dfs(rows - 1, c, heights, atlantic, dr, dc);
24        }
25        for (int r = 0; r < rows; r++) {
26            dfs(r, cols - 1, heights, atlantic, dr, dc);
27        }
28
29        List<List<Integer>> result = new ArrayList<>();
30
31        for (int r = 0; r < rows; r++) {
32            for (int c = 0; c < cols; c++) {
33                if (pacific[r][c] && atlantic[r][c]) {
34                    result.add(Arrays.asList(r, c));
35                }
36            }
37        }
38
39        return result;
40    }
41
42    private void dfs(int r, int c, int[][] heights, boolean[][] visited, int[] dr, int[] dc) {
43        visited[r][c] = true;
44
45        for (int k = 0; k < 4; k++) {
46            int nr = r + dr[k];
47            int nc = c + dc[k];
48
49            if (nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length)
50                continue;
51
52        
53            if (!visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
54                dfs(nr, nc, heights, visited, dr, dc);
55            }
56        }
57    }
58}
59