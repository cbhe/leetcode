package 剑指offer;

public class Sro39majorityElement {

    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int i = 1; i<nums.length;i++){
            if (nums[i] == ret) count++;
            else count--;
            if (count == 0){
                ret = nums[i];
                count = 1;
            }
        }
        return ret;
    }
}
