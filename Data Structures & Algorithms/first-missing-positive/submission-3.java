class Solution {
    public int firstMissingPositive(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num: nums) set.add(num);

        // int i = 0;

        // while (true) {
        //     if (!set.contains(++i)) return i;
        // }

        // int n = nums.length;

        // boolean[] seen = new boolean[n];

        // for (int num: nums) {
        //     if (num > 0 && num <= n) {
        //         seen[num - 1] = true;
        //     }
        // }

        // for (int i = 0 ; i < n; i++) {
        //     if (!seen[i]) return i + 1;
        // }


        // return n + 1;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (n + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= 0) return i;
        }

        return n + 1;
    }
}