class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < numbers.length; i++) {
        //     if (map.containsKey(target - numbers[i])) {
        //         return new int[]{map.get(target - numbers[i]) + 1, i + 1};
        //     }
        //     map.put(numbers[i], i);
        // }

        // return new int[]{-1, -1};


        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];
            if (curSum > target) {
                r--;
            } else if (curSum < target) {
                l++;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }


        return new int[0];
    }
}
