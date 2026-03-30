class Solution {
    public void rotate(int[] nums, int k) {
        //         if (k == nums.length) return;
        // k %= nums.length; 
        // for (int j = 0; j < k; j++) {
        //     int last = nums[nums.length - 1];

        //     for (int i = nums.length - 1; i > 0; i--) {
        //         nums[i] = nums[i - 1];
        //     }
        //     nums[0] = last;
        // }


        int n = nums.length;
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
    }
}