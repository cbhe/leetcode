package 力扣;

import java.util.HashMap;
import java.util.Map;

public class Lc309maxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(new Lc309maxProfit().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        Integer[] buy = new Integer[prices.length]; // buy[i] = idleWithoutStock[i-1] - prices[i]
        Integer[] sale = new Integer[prices.length]; // sale[i] = max(buy[i-1]+prices[i], idleWithStock[i-1]+prices[i])
        Integer[] idleWithStock = new Integer[prices.length]; // idleWithStock[i] = max(idleWithStock[i-1], buy[i-1])
        Integer[] idleWithoutStock = new Integer[prices.length]; // idleWithoutStock[i] = max(sale[i-1], idleWithoutStock[i-1])

        buy[0] = -prices[0];
        sale[0] = null;
        idleWithStock[0] = null;
        idleWithoutStock[0] = 0;

        for (int i=1; i<prices.length; i++){
            buy[i] = moneySubtract(idleWithoutStock[i-1], prices[i]);
            sale[i] = moneyMax(moneyAdd(buy[i-1],prices[i]), moneyAdd(idleWithStock[i-1], prices[i]));
            idleWithStock[i] = moneyMax(idleWithStock[i-1], buy[i-1]);
            idleWithoutStock[i] = moneyMax(sale[i-1], idleWithoutStock[i-1]);
        }

        return moneyMax(sale[prices.length-1], idleWithoutStock[prices.length-1]);
    }

    private Integer moneyAdd(Integer a, Integer b){
        if (a == null || b == null) return null;
        return a + b;
    }
    private Integer moneySubtract(Integer a, Integer b){
        if (a == null || b == null) return null;
        return a - b;
    }
    private Integer moneyMax(Integer a, Integer b){
        if (a == null && b == null) return null;
        if (a == null) return b;
        if (b == null) return a;
        return Math.max(a, b);
    }
}
