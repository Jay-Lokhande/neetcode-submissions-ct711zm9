class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;

        int candidate1 = -1;
        int candidate2 = -1;

        for (int num: nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num){
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) count1++;
            if (candidate2 == nums[i]) count2++;
        }

        if (count1 > nums.length/3) res.add(candidate1);
        if (count2 > nums.length/3) res.add(candidate2);

        return res;
    }
}