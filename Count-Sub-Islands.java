1class Solution {
2      public int countSubIslands(int[][] B, int[][] A) {
3        int m = A.length, n = A[0].length, res = 0;
4        for (int i = 0; i < m; i++)
5            for (int j = 0; j < n; j++)
6                if (A[i][j] == 1)
7                    res += dfs(B, A, i, j);
8        return res;
9    }
10
11
12    private int dfs(int[][] B, int[][] A, int i, int j) {
13        int m = A.length, n = A[0].length, res = 1;
14        if (i < 0 || i == m || j < 0 || j == n || A[i][j] == 0) return 1;
15        A[i][j] = 0;
16        res &= dfs(B, A, i - 1, j);
17        res &= dfs(B, A, i + 1, j);
18        res &= dfs(B, A, i, j - 1);
19        res &= dfs(B, A, i, j + 1);
20        return res & B[i][j];
21    }
22}