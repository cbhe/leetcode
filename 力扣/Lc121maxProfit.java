package 力扣;

import java.net.Inet4Address;

public class Lc121maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }

        int min = prices[0];
        int ret = 0;
        for (int i=1; i<prices.length;i++){
            int profit = prices[i] - min;
            ret = Math.max(ret, profit);
            min = Math.min(min, prices[i]);
        }
        return ret;
    }
}
