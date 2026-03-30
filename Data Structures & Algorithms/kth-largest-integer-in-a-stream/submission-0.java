class KthLargest {
    PriorityQueue<Integer> pq;
    int a;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        a = k;
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > a) pq.poll();

        return pq.peek();
    }
}
