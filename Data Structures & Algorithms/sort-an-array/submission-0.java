class Solution {

    public int partition(int[] nums, int low, int high) {
        
        int pivot = nums[high];

        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }


        swap(nums, i + 1, high);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {

            int pi = partition (nums, left, right);
            quickSort(nums, left, pi - 1);
            quickSort(nums, pi + 1, right);

        }
    }
    public int[] sortArray(int[] nums) {

        int n = nums.length;
        quickSort(nums, 0, n - 1);

        return nums;
    }
}