package 力扣;

import java.util.ArrayList;

public class Lc1065indexPairs {
    public int[][] indexPairs(String text, String[] words) {

        if (words.length == 0) return new int[0][0];

        ArrayList<int[]> ret = new ArrayList<>();
        for (String word: words){
            ret.addAll(findWordIndex(text, word));
        }
        int[][] nums =  ret.toArray(new int[0][0]);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    private ArrayList<int[]> findWordIndex(String base, String target){
        ArrayList<int[]> ret = new ArrayList();
        for (int i = 0; i + target.length() - 1 < base.length(); i++){

            int j = 0;
            for (; j<target.length();j++){
                if (target.charAt(j) != base.charAt(i+j)){
                    break;
                }
            }
            if (j >= target.length()){
                ret.add(new int[]{i, i+j-1});
            }
        }
        return ret;
    }
    private void quickSort(int[][] nums, int left, int right){
        if (left >= right){
            return;
        }
        int l = left;
        int r = right;
        int[] base = nums[l];
        while (l<r){
            while (l<r){
                if ((nums[r][0] > base[0]) || (nums[r][0] == base[0] && nums[r][1] >= base[1])){
                    r--;
                } else {
                    nums[l] = nums[r];
                    l++;
                    break;
                }
            }
            while (l<r){
                if ((nums[l][0] < base[0]) || (nums[l][0] == base[0] && nums[l][1] <= base[1])){
                    l++;
                } else {
                    nums[r] = nums[l];
                    r--;
                    break;
                }
            }
        }
        nums[l] = base;
        quickSort(nums, left, l-1);
        quickSort(nums,l+1, right);
    }
}
