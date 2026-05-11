class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
            freq.get(a) - freq.get(b)
        );

        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i : freq.keySet()) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
