class NumMatrix {
    // int[][] copy;
    // private int[][] prefixSum;
    private int[][] sumMat;
    public NumMatrix(int[][] matrix) {
        // copy = matrix;

        int rows = matrix.length;
        int cols = matrix[0].length;
        // prefixSum = new int[rows][cols];
        // for (int row = 0; row < rows; row++) {
        //     prefixSum[row][0] = matrix[row][0];
        //     for (int col = 1; col < cols; col++) {
        //         prefixSum[row][col] = matrix[row][col] + prefixSum[row][col-1];
        //     }
        // }

        sumMat = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            int prefix = 0;
            for (int c = 0; c < cols; c++) {
                prefix += matrix[r][c];
                int above = sumMat[r][c + 1];
                sumMat[r + 1][c + 1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // int sum = 0;
        // for (int i = row1; i <= row2; i++) {
        //     for (int j = col1; j <= col2; j++) {
        //         sum += copy[i][j];
        //     }
        // }
        // return sum;

        // int res = 0;

        // for (int row = row1; row <= row2; row++) {
        //     if (col1 > 0) {
        //         res += prefixSum[row][col2] - prefixSum[row][col1 - 1];
        //     } else {
        //         res += prefixSum[row][col2];
        //     }
        // }

        // return res;


        row1++; col1++; row2++; col2++;

        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1 - 1][col2];
        int left = sumMat[row2][col1 - 1];
        int topLeft = sumMat[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */