package 力扣;

import java.util.Arrays;

public class Lc718findLength {

    public static void main(String[] args) {
        int[] num1 = new int[]{0,1,1,1,1};
        int[] num2 = new int[]{1,0,1,0,1};
        System.out.println(new Lc718findLength().findLength(num1, num2));
    }
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;

        return dp(nums1, nums2);
    }

    public int dp(int[] nums1, int[] nums2){
        // nums1[i] == nums2[j] , 则已经扩展到 nums1[i-1],nums2[j-1] 的公共字符串长度 +1
        // 如果没有前面的元素,则相等为 1,不相等为 0
        int maxLen = 0;
        int[][] dpMatrix = new int[nums1.length][nums2.length];
        for (int i = 0; i< nums1.length; i++){
            for (int j = 0; j<nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    if (i!=0 && j!=0){
                        dpMatrix[i][j] =  dpMatrix[i-1][j-1] + 1;
                    } else {
                        dpMatrix[i][j] = 1;
                    }
                    maxLen = Math.max(maxLen, dpMatrix[i][j]);
                }
            }
        }
        return maxLen;
    }

}
