class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();

        for (int num = 0; num < nums.length; num++) {
            if (set.containsKey(target - nums[num])) return new int[] {set.get(target- nums[num]), num};
            set.put(nums[num], num);
        }

        return new int[]{-1, -1};
    }
}
