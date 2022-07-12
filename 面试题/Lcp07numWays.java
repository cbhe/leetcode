package 面试题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lcp07numWays {
    public int numWays(int n, int[][] relation, int k) {
        List<Set<Integer>> nextList = new ArrayList<>();
        for (int i = 0; i<n;i++) nextList.add(new HashSet<>());
        for (int[] rela: relation){
            int x = rela[0];
            int y = rela[1];
            nextList.get(x).add(y);
        }

//        int[] num = new int[1];
//
//        dfs(nextList, 0, k, num);
//        return num[0];

        return dp(n, relation, k, nextList);
    }
    private void dfs(List<Set<Integer>> nextList, int index, int k, int[] num){
        if (k == 0){
            if (index == nextList.size()-1){
                num[0] += 1;
            }
            return;
        }

        for (int nextIndex: nextList.get(index)){
            dfs(nextList, nextIndex, k-1, num);
        }
    }

    private int dp(int n, int[][] relation, int k, List<Set<Integer>> nextList){
        int[][] dpMatrix = new int[k+1][n];
        dpMatrix[0][0] = 1;
        for (int i = 1; i<k+1; i++){
            for (int j = 0; j< n; j++){
                for (int x = 0; x<n; x++){
                    if (nextList.get(x).contains(j)){
                        dpMatrix[i][j] += dpMatrix[i-1][x];
                    }
                }
            }
        }
        return dpMatrix[k][n-1];
    }
}
