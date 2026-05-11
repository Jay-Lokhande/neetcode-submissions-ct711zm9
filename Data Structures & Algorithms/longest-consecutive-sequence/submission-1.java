class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int max = 0;

        for (int i: set) {
            int num = i;
            int l = 0;
            while (set.contains(num)) {
                l++;
                num++;
            }

            max = Math.max(max, l);
        }

        return max;
    }
}
