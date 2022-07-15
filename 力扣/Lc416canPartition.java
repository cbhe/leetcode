package 力扣;

public class Lc416canPartition {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) return false;
        int sum = 0;
        int maximum = nums[0];
        for (int num : nums) {
            sum += num;
            maximum = Math.max(maximum, num);
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        if (maximum > target) return false;

        int[][] dp = new int[nums.length+1][target +1];
        for (int i=1;i<nums.length+1;i++){
            for (int c=1;c< target +1;c++){
                int take = 0, abandon=0;
                if (c>=nums[i-1]){
                    take = dp[i-1][c-nums[i-1]] + nums[i-1];
                }
                abandon = dp[i-1][c];
                dp[i][c] = Math.max(take,abandon);
            }
        }
        return dp[nums.length][target] == target;
    }
}
