package 面试题;

public class Q1716massage {
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i<dp.length;i++){
            int appoint = dp[i-2] + nums[i];
            int noAppoint = dp[i-1];
            dp[i] = Math.max(appoint, noAppoint);
        }

        return dp[dp.length-1];
    }
}
