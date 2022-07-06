package 剑指offer;

public class Sro04findNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 20;
        System.out.println(new Sro04findNumberIn2DArray().findNumberIn2DArray(matrix, target));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        return find(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
    }

    private boolean find(int[][] matrix, int target, int top, int bottom, int left, int right){

        if (left > right || top > bottom){
            return false;
        }

        int i = top + (bottom - top) / 2;
        int j = left + (right - left) / 2;

        if (target == matrix[i][j]){
            return true;
        } else if (target > matrix[i][j]){
            return find(matrix, target, i+1, bottom, left, right)
                    || find(matrix, target, top, i, j+1, right);
        } else { // if (target < matrix[i][j])
            return find(matrix, target, top, i-1, left, right)
                    || find(matrix, target, i, bottom, left, j-1);
        }
    }
}
