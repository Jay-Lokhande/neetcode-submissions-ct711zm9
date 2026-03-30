class Solution {
    public int removeElement(int[] nums, int val) {
        // int k = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != val) nums[k++] = nums[i];
        // }

        // return k;

        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }

        return n;
    }
}