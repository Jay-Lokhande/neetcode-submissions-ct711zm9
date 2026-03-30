class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]); 
            adj.get(edge[1]).add(edge[0]); 
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(adj, visit, i);
                res++;
            }
        }

        return res;
    }

    public void bfs(List<List<Integer>> adj, boolean[] visit, int node) {
        visit[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int i = q.poll();
            for (int nei: adj.get(i)) {
                if (!visit[nei]) {
                    visit[nei] = true;
                    q.add(nei);
                }
            }        
        }
    }
}
