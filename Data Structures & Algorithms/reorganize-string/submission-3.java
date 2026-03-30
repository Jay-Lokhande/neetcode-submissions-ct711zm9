class Solution {

    public String reorganizeString(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add(new int[]{count[i], i});
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;

        while (!pq.isEmpty() || prev != null) {
            if (prev != null && pq.isEmpty()) {
                return "";
            }

            int[] curr = pq.poll();

            res.append((char) (curr[1] + 'a'));
            curr[0]--;

            if (prev != null) {
                pq.add(prev);
                prev = null;
            }

            if (curr[0] > 0) {
                prev = curr;
            }
        }

        return res.toString();
    }
}