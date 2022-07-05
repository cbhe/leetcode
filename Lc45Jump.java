public class Lc45Jump {

    public static void main(String[] args) {
        int[] nums = new int[]{5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0};
        System.out.println(new Lc45Jump().jump(nums));
    }
    public int jump(int[] nums) {
        int jumpCount = 0;
        int position = nums.length-1;
        while(position > 0){
            for (int i = 0; i < position; i++){
                if (i+nums[i] >= position){
                    position = i;
                    jumpCount++;
                }
            }
        }
        return jumpCount;
    }
}
