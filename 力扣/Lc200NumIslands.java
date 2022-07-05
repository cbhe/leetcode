package 力扣;

import java.util.HashSet;
import java.util.Set;

// 200. 岛屿数量
public class Lc200NumIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}};

        Lc200NumIslands numIslands =  new Lc200NumIslands();
        int islandNum = numIslands.numIslands(grid);
        System.out.println(islandNum);
    }
    public int numIslands(char[][] grid) {
        Set<String> islandPointSet = new HashSet<>();
        int islandNum = 0;
        for (int rol = 0; rol < grid.length; rol ++){
            for (int col = 0; col < grid[0].length; col ++){
                String pointCoordinate = rol + "," + col; // todo: 抽取成函数作为坐标表示标准
                // 新出现的陆地点
                if (grid[rol][col] == '1' && !islandPointSet.contains(pointCoordinate)){
                    islandNum ++;
                    // 将该岛屿全部点添加到岛屿点集合
                    expandIsland(grid, rol, col, islandPointSet);
                }
            }
        }
        return islandNum;
    }
    private void expandIsland(char[][] grid, int rol, int col, Set<String> islandPointSet){
        // 到达岛屿边界
        if ((rol < 0 || rol > grid.length - 1)
                || (col < 0 || col > grid[0].length - 1)
                || grid[rol][col] == '0'){
            return;
        }

        // 已遍历过
        String pointCoordinate = rol + "," + col;
        if (islandPointSet.contains(pointCoordinate)){ // 内外层都判断了,有些冗余,需要优化逻辑
            return;
        }

        // 扩展到岛屿坐标集合
        islandPointSet.add(pointCoordinate);

        // 继续扩展其他点
        // 上
        expandIsland(grid, rol - 1 , col, islandPointSet);
        // 下
        expandIsland(grid, rol + 1, col, islandPointSet);
        // 左
        expandIsland(grid, rol, col - 1, islandPointSet);
        // 右
        expandIsland(grid, rol, col + 1, islandPointSet);
    }
}
