class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
         for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                dfs(0, j, vis, grid);
            }
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) {
                dfs(n - 1, j, vis, grid);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, vis, grid);
            }
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                dfs(i, m - 1, vis, grid);
            }
        }

        int count =0;
        for( int r = 0 ; r <  grid.length; r++){
            for( int c=0; c < grid[0].length;c++){
                if(grid[r][c] == 1 && vis[r][c] == 0){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs( int i , int j , int[][] vis , int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        if( i < 0 || i >=r || j < 0 ||j >=c || grid[i][j] ==0 || vis[i][j]==1){
            return;
        }       vis[i][j] = 1;

        dfs(i+1 ,j , vis , grid);
        dfs(i-1 , j , vis , grid);
        dfs( i , j-1 , vis , grid);
        dfs(i , j+1 , vis ,grid);

    }
}