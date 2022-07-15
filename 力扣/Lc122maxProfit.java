package 力扣;

public class Lc122maxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new Lc122maxProfit().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        Integer[] arr1 = new Integer[prices.length]; // 买入
        Integer[] arr2 = new Integer[prices.length]; // 卖出
        Integer[] arr3 = new Integer[prices.length]; // 持有且不做交易
        Integer[] arr4 = new Integer[prices.length]; // 不持有且不做交易

        arr1[0] = -prices[0]; //
        arr2[0] = null; // 第0 天,无法进行卖出操作
        arr3[0] = null; // 第 0 天,无法持有任何股票
        arr4[0] = 0; // 第 0 天不持有且不做交易,最大收益当然是 0

        for(int i=1; i<prices.length; i++){
            // 今天买入, 最大收益 = max (昨天卖出, 昨天不持有且没做交易)
            arr1[i] = max(subtract(arr2[i-1], prices[i]), subtract(arr4[i-1], prices[i]));
            // 今天卖出, 最大收益 = max(昨天买入, 昨天持有且没有交易)
            arr2[i] = max(add(arr1[i-1], prices[i]), add(arr3[i-1], prices[i]));
            // 今天持有且不交易 = max(昨天持有且不做交易, 昨天买入)
            arr3[i] = max(arr3[i-1], arr1[i-1]);
            // 今天不持有也不做交易 = max(昨天卖出, 昨天不持有且不做交易)
            arr4[i] = max(arr2[i-1], arr4[i-1]);
        }
        return max(arr4[arr4.length-1], arr2[arr2.length-1]);
    }

    private Integer add(Integer a, Integer b){
        if (a==null || b==null) return null;
        return a + b;
    }
    private Integer subtract(Integer a, Integer b){
        if (a==null || b==null) return null;
        return a - b;
    }
    private Integer max(Integer a, Integer b){
        if (a==null && b==null) return null;
        if (a==null) return b;
        if (b==null) return a;
        return Math.max(a, b);
    }
}
