package 力扣;

public class Lc540singleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,10,11,11,12,12};
        System.out.println(new Lc540singleNonDuplicate().singleNonDuplicate(nums));
    }
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        int left = 1;
        int right = nums.length-2;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if (mid % 2 == 0){ // mid 前有偶数个元素
                if (nums[mid] == nums[mid-1]){
                    right = mid-2;
                } else {
                    left = mid+1;
                }
            } else {  // mid 前有奇数个元素
                if (nums[mid] == nums[mid-1]){
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
