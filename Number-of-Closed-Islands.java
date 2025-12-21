1class Solution {
2
3    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
4    
5    public int closedIsland(int[][] grid) {
6        int res = 0;
7        for(int i = 0; i < grid.length; i++){
8            for(int j = 0; j < grid[0].length; j++){
9                if(grid[i][j] == 0){
10                    if(dfs(grid, i, j)) res++;
11                }
12            }
13        }
14        
15        return res;
16    }
17    
18    public boolean dfs(int[][] grid, int x, int y){
19        
20        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
21        
22        if(grid[x][y] == 1) return true;
23        
24        grid[x][y] = 1;
25        
26        boolean res = true;
27        
28        for(int[] d : dir){
29            res = res & dfs(grid, x + d[0], y + d[1]);
30        }
31        
32        return res;
33    }
34}