package 剑指offer;

public class Sro42maxSubArray {
    public int maxSubArray(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        for (int i = 1; i<nums.length;i++){
            if (nums[i-1] > 0){
                nums[i] = nums[i-1]+nums[i];
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i<nums.length;i++){
            ret = Math.max(ret, nums[i]);
        }

        return ret;
    }
}
