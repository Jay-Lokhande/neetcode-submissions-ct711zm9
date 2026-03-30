class Solution {
    public void rotate(int[] nums, int k) {
                if (k == nums.length) return;
        k %= nums.length; 
        for (int j = 0; j < k; j++) {
            int last = nums[nums.length - 1];

            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
        }
    }
}