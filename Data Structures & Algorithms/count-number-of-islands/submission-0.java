class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';

        q.add(new int[]{r, c});
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for (int[] dir: dirs) {
                int u = row + dir[0];
                int v = col + dir[1];


                if (u >= 0 && v >= 0 && u < grid.length && v < grid[0].length && grid[u][v] == '1') {
                    q.add(new int[]{u, v});
                    grid[u][v] = '0';
                }
            }
        }
    }
}
