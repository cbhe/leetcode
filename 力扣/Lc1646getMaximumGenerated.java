package 力扣;

public class Lc1646getMaximumGenerated {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(new Lc1646getMaximumGenerated().getMaximumGenerated(n));
    }
    public int getMaximumGenerated(int n) {
        /*
            当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
            当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
         */
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 0; i < arr.length; i++){
            if (2*i >= 2 && 2*i <=n){
                arr[2*i] = arr[i];
            }
            if (2*i+1>=2 && 2*i+1<=n){
                arr[2*i+1] = arr[i] + arr[i+1];
            }
        }

        int ret = arr[0];
        for (int i = 0; i<arr.length; i++){
            ret = Math.max(ret, arr[i]);
        }

        return ret;
    }
}
