package 力扣;

public class Lc1025divisorGame {
    public boolean divisorGame(int n) {
        if (n == 1) return false;
        if (n == 2) return true;

        boolean[] dp = new boolean[n+1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i<=n; i++){
            boolean temp = true;
            for (int j = 1; j<i && i % j == 0; j++){
                // 只要有一个是 false 则 temp 最终为 false
                temp = temp && dp[i-j];
            }
            // 只要下一步有一个是 false(必输), 则这一步必赢
            dp[i] = !temp;
        }

        return dp[n];
    }
}
