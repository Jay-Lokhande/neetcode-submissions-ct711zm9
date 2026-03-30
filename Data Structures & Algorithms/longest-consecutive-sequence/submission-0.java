class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int max = 0;
        int len = 0;
        for (int num: set) {   

            if (!set.contains(num - 1)) {
                len = 0;
                int curr = num;
                while (set.contains(curr)) {
                    curr++;
                    len++;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }
}
