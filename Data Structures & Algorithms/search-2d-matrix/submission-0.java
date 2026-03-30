class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][n - 1] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }

        if (!(left <= right)) {
            return false;
        }

        int row = (left + right) / 2;

        int l = 0, r = n -1;

        while (l <= r) {
            m = (l + r) / 2;

            if (matrix[row][m] == target) return true;
            else if (matrix[row][m] > target) {
                r = m - 1;
            } else l = m + 1;
        }


        return false;
    }
}
