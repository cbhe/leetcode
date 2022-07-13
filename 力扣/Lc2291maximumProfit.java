package 力扣;

import java.util.ArrayList;
import java.util.List;

public class Lc2291maximumProfit {

    public static void main(String[] args) {
        int[] present = new int[]{0};
        int[] future = new int[]{1};
        int budget = 0;
        System.out.println(new Lc2291maximumProfit().maximumProfit(present, future, budget));
    }
    public int maximumProfit(int[] present, int[] future, int budget) {

        int[][] dp = new int[present.length+1][budget+1];
        for (int i=1; i<present.length+1; i++){
            for (int j=0;j<budget+1;j++){
                if (j-present[i-1] >=0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-present[i-1]] + future[i-1]-present[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[present.length][budget];
    }
}
