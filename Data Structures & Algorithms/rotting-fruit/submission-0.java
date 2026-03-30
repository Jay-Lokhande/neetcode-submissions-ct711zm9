class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }


        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();

            for (int i = 0; i < length; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir: dirs) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0? time : -1;
    }
}
