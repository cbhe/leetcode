package 力扣;

import java.util.Arrays;

public class Lc912sortArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,2,8,7,9,5};
        System.out.println(Arrays.toString(new Lc912sortArray().sortArray(nums)));
    }
    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length-1);
        // mergeSort(nums, 0, nums.length-1);
        bubbleSort(nums);
        return nums;
    }

    private void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int l = left;
        int r = right;

        // 随机取其中一个数字作为 base
        int m = (int)(Math.random() * (right-left+1) + left);
        int temp = arr[l];
        arr[l] = arr[m];
        arr[m] = temp;

        int base = arr[l];

        while (l<r){
            while (l<r){
                if (arr[r] >= base){
                    r--;
                } else {
                    arr[l] = arr[r];
                    l++;
                    break;
                }
            }
            while (l<r){
                if (arr[l] <= base){
                    l++;
                } else {
                    arr[r] = arr[l];
                    r--;
                    break;
                }
            }
            arr[l] = base;
            quickSort(arr, left, l-1);
            quickSort(arr, l+1, right);
        }
    }

    private void mergeSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }

        int mid = left + (right-left) /2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j<=right){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while (j<=right){
            temp[k++] = arr[j++];
        }
        for (k=0;k<temp.length;k++){
            arr[left+k] = temp[k];
        }
    }
    private void bubbleSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
