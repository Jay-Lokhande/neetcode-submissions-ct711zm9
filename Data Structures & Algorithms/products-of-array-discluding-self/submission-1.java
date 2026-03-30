class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int mul = 1;
        // int zeroCount = 0;
        // int[] res = new int[nums.length];
        // for (int num: nums) { 
        //     if (num != 0) {
        //         mul *= num;
        //     } else {
        //         zeroCount++;
        //     }
        // }
        // if (zeroCount > 1) return res;

        // for (int i = 0; i < nums.length; i++) {
        //     if (zeroCount > 0) {
        //         res[i] = (nums[i] == 0) ? mul : 0;
        //     }
        //     else res[i] = mul/nums[i];

        // }

        // return res;

        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = suff[i] * pref[i];
        }

        return res;
    }
}  
