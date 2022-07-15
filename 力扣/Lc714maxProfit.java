package 力扣;

public class Lc714maxProfit {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) return 0;

        int[] hold = new int[prices.length];
        int[] free = new int[prices.length];

        hold[0] = -prices[0];
        free[0] = 0;

        for (int i=1; i<prices.length; i++){
            hold[i] = Math.max(hold[i-1], free[i-1]-prices[i]);
            free[i] = Math.max(hold[i-1]+prices[i]-fee, free[i-1]);
        }

        return free[free.length-1];
    }
}
