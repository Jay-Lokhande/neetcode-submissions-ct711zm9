class Solution {
    private int ROWS;
    private int COLS;
    private int INF = 2147483647;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS;c++) {
                if (grid[r][c] == INF) {
                    grid[r][c] = bfs(grid, r, c);
                }
            }
        }    
    }
    public int bfs(int[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        boolean[][] visit = new boolean[ROWS][COLS];
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            if (grid[row][col] == 0) return steps;

            for (int[] dir: dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r >= 0 && r < ROWS && c >= 0 && c < COLS 
                    && !visit[r][c] && grid[r][c] != -1) {
                        visit[r][c] = true;
                        q.add(new int[]{r, c});
                }
            }
            }
            steps++; 
        }

        return steps;
    }
}
