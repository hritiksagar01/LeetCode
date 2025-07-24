class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all initially rotten oranges to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c, 0}); // row, col, minute
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], time = current[2];
            minutes = time; // track last time level

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check if neighbor is a fresh orange
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; // rot it
                    fresh--;
                    queue.offer(new int[]{nr, nc, time + 1});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}