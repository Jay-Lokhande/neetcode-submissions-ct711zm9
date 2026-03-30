class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int zeroCount = 0;
        int[] res = new int[nums.length];
        for (int num: nums) { 
            if (num != 0) {
                mul *= num;
            } else {
                zeroCount++;
            }
        }
        if (zeroCount > 1) return res;

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? mul : 0;
            }
            else res[i] = mul/nums[i];

        }

        return res;

    }
}  
