class Solution {
    class Pair {
        int[] point;
        double dist;

        Pair (int[] point, double dist) {
            this.point = point;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.dist, a.dist)
        );

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];

            pq.add(new Pair(new int[]{x, y}, Math.sqrt(x*x + y*y)));

            if (pq.size() > k) pq.poll();
        }
        int n = pq.size();
        int[][] res = new int[n][2];

        for (int i = 0; i < n; i++) {
            Pair pair = pq.poll();
            res[i][0] = pair.point[0];
            res[i][1] = pair.point[1];
        }

        return res;
    }
}
