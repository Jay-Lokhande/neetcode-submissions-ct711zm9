class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int per = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir: dirs) {
                        int u = i + dir[0];
                        int v = j + dir[1];
                        
                        if (u < 0 || v < 0 || u >= n || v >= m || grid[u][v] == 0) {
                            per++;
                        }
                    }

                }
            }
        }

        return per;
    }
}