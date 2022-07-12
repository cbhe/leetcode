package 剑指offer;

public class Sro88iiMinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        int[] dpArr = new int[cost.length+1];
        dpArr[0] = cost[0];
        dpArr[1] = cost[1];
        for (int i = 2; i<dpArr.length-1;i++){
            dpArr[i] = Math.min(dpArr[i-1], dpArr[i-2]) + cost[i];
        }
        dpArr[dpArr.length-1] = Math.min(dpArr[dpArr.length-2], dpArr[dpArr.length-3]) + 0;

        return dpArr[dpArr.length-1];
    }
}
