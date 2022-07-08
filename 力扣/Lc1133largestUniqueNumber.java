package 力扣;

public class Lc1133largestUniqueNumber {
    public int largestUniqueNumber(int[] nums) {

        if (nums.length == 0) return -1;
        quickSort(nums, 0, nums.length-1);
        for (int i = 0; i<nums.length;i++){
            if ((i-1 < 0 || nums[i] != nums[i-1]) && (i+1> nums.length-1 || nums[i] != nums[i+1])){
                return nums[i];
            }
        }
        return -1;
    }
    private void quickSort(int[] nums, int left, int right){
        if (left>=right) return;
        int l = left;
        int r = right;
        int base = nums[l];
        while (l<r){
            while (l<r){
                if (nums[r] <= base){
                    r--;
                } else {
                    nums[l] = nums[r];
                    l++;
                    break;
                }
            }
            while (l<r){
                if (nums[l] >= base){
                    l++;
                } else {
                    nums[r] = nums[l];
                    r--;
                    break;
                }
            }
        }
        nums[l] = base;
        int m = l;
        quickSort(nums, left, m-1);
        quickSort(nums, m+1, right);
    }
}
