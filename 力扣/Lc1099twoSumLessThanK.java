package 力扣;

public class Lc1099twoSumLessThanK {

    public static void main(String[] args) {
        int[] nums = new int[]{34,23,1,24,75,33,54,8};
        int k = 60;
        System.out.println(new Lc1099twoSumLessThanK().twoSumLessThanK(nums, k));
    }

    public int twoSumLessThanK(int[] nums, int k) {

        if (nums.length < 1) return -1;

        quickSort(nums, 0, nums.length-1);
        int left = 0;
        int right = nums.length-1;

        int max = -1;
        while(left<right){
            int sum = nums[left] + nums[right];
            if (sum >= k){
                right--;
            } else {
                if (sum > max){
                    max = sum;
                }
                left++;
            }
        }

        return max;
    }

    private void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }

        int l = left;
        int r = right;
        int base = nums[l];
        while (l<r){
            while (l<r){
                if (nums[r] >= base){
                    r--;
                } else {
                    nums[l] = nums[r];
                    l++;
                    break;
                }
            }
            while (l<r){
                if (nums[l] <= base){
                    l++;
                } else {
                    nums[r] = nums[l];
                    r--;
                    break;
                }
            }
        }
        int m = l;
        nums[m] = base;
        quickSort(nums, left, m-1);
        quickSort(nums, m+1, right);
    }
}
