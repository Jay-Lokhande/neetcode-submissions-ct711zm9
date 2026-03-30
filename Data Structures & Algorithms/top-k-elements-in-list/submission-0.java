class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i: map.keySet()) {
            pq.add(i);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }

        return res;

    }
}
