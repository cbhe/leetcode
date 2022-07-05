package 力扣;

public class Lc696maxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new Lc696maxAreaOfIsland().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 1){
                    int[] size = new int[1];
                    getIslandSize(grid, i, j, size);
                    maxSize = Math.max(maxSize, size[0]);
                }
            }
        }
        return maxSize;
    }

    private void getIslandSize(int[][] grid, int row, int col, int[] size){
        if (row < 0 || row > grid.length-1) return;
        if (col < 0 || col > grid[0].length-1) return;

        if (grid[row][col] == 0) return;

        grid[row][col] = 0;
        size[0]++;

        getIslandSize(grid, row-1, col, size);
        getIslandSize(grid, row+1, col, size);
        getIslandSize(grid, row, col-1, size);
        getIslandSize(grid, row, col+1, size);
    }
}
