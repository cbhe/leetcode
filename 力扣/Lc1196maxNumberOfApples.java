package 力扣;

public class Lc1196maxNumberOfApples {

    public static void main(String[] args) {
        int[] weight = new int[]{367,608,768,122,546,569,258,30,751,406};
        System.out.println(new Lc1196maxNumberOfApples().maxNumberOfApples(weight));
    }
    public int maxNumberOfApples(int[] weight) {
        if (weight == null || weight.length == 0){
            return 0;
        }
        quickSort(weight, 0, weight.length-1);

        int total = 0;
        for (int i = 0; i<weight.length;i++){
            total += weight[i];
            if (total > 5000){
                return i;
            }
        }
        return weight.length;
    }

    private void quickSort(int[] nums, int left, int right){

        if (left >= right) return;
        int l = left;
        int r = right;
        int base = nums[l];
        while(l<r){
            while(l<r){
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
