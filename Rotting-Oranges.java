class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c, 0}); 
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], time = current[2];
            minutes = time; 

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; 
                    fresh--;
                    queue.offer(new int[]{nr, nc, time + 1});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}