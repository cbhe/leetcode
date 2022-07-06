package 剑指offer;

import java.util.logging.Level;

public class Sro13movingCount {
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;

        int[][] matrix = new int[m][n];
        trackBack(matrix, 0, 0, k);

        int ret = 0;
        for (int i = 0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 1) ret++;
            }
        }
        return ret;
    }
    private void trackBack(int[][] matrix, int row, int col, int k){

        // 结束条件
        if (row < 0 || row >= matrix.length) return;
        if (col < 0 || col >= matrix[0].length) return;

        // 剪枝
        if (digitSum(row) + digitSum(col) > k) return;
        if (matrix[row][col] == 1) return;

        // visit
        matrix[row][col] = 1;

        // 回溯
        trackBack(matrix, row-1, col, k);
        trackBack(matrix, row+1, col, k);
        trackBack(matrix, row, col-1, k);
        trackBack(matrix, row, col+1, k);
    }
    private int digitSum(int n){
        if (n<10){
            return n;
        }
        int sum = 0;
        while(n>0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
