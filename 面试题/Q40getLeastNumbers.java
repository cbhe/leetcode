package 面试题;

import java.util.Arrays;

public class Q40getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0){
            return new int[0];
        }
        quickSort(arr, 0, arr.length-1);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void quickSort(int[] arr, int left, int right){
        if (left >= right) return;
        int l = left;
        int r = right;
        int base = arr[l];
        while(l<r){
            while(l<r){
                if (arr[r] >= base){
                    r--;
                } else {
                    arr[l] = arr[r];
                    l++;
                    break;
                }
            }
            while(l<r){
                if (arr[l] <= base){
                    l++;
                } else {
                    arr[r] = arr[l];
                    r--;
                    break;
                }
            }
        }
        arr[l] = base;
        quickSort(arr, left, l-1);
        quickSort(arr, l+1, right);
    }
}
