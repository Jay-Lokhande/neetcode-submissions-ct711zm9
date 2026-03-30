class Solution {
    public int firstMissingPositive(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num: nums) set.add(num);

        // int i = 0;

        // while (true) {
        //     if (!set.contains(++i)) return i;
        // }

        int n = nums.length;

        boolean[] seen = new boolean[n];

        for (int num: nums) {
            if (num > 0 && num <= n) {
                seen[num - 1] = true;
            }
        }

        for (int i = 0 ; i < n; i++) {
            if (!seen[i]) return i + 1;
        }


        return n + 1;
    }
}