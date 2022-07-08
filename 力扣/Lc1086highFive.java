package 力扣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc1086highFive {

    public static void main(String[] args) {
        int[][] items = new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        System.out.println(Arrays.deepToString(new Lc1086highFive().highFive(items)));
    }
    public int[][] highFive(int[][] items) {

        if (items.length == 0) return new int[1][0];

        quickSort(items, 0, items.length-1);

        int left = 0;
        int right = 0;

        List<int[]> list = new ArrayList<>();
        while(left < items.length && right < items.length){
            int id = items[left][0];
            int total = 0;
            for (right = left; right-left<5;right++){
                total += items[right][1];
            }
            list.add(new int[]{id, total/5});

            for (left = right; left < items.length; left++){
                if (items[left][0] != id){
                    break;
                }
            }
        }
        return list.toArray(new int[0][0]);
    }

    private void quickSort(int[][] items, int left, int right){
        if (left>=right){
            return;
        }
        int l = left;
        int r = right;
        int[] base = items[l];
        int baseId = base[0];
        int baseScore = base[1];
        while (l<r){
            while (l<r){
                int id = items[r][0];
                int score = items[r][1];
                if (id > baseId || (id == baseId && score <= baseScore)){
                    r--;
                }else {
                    items[l] = items[r];
                    l++;
                    break;
                }
            }
            while (l<r){
                int id = items[l][0], score = items[l][1];
                if ((id < baseId) || (id == baseId && score >= baseScore)){
                    l ++;
                } else {
                    items[r] = items[l];
                    r--;
                    break;
                }
            }
        }
        int m = l;
        items[m] = base;
        quickSort(items, left, m-1);
        quickSort(items, m+1, right);
    }
}
