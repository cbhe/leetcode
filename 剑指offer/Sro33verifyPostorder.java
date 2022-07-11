package 剑指offer;

public class Sro33verifyPostorder {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 6, 12, 16, 14, 10};
        System.out.println(new Sro33verifyPostorder().verifyPostorder(arr));
    }
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <=1) return true;
        return isPostorder(postorder, 0, postorder.length-1);
    }

    private boolean isPostorder(int[] arr, int left, int right){
        if (left >= right) return true;
        int root = arr[right];

        int index = left;
        int nextRootIndex = right-1;
        for (index = left; index <= right-1; index++){
            if (arr[index] > root){
                nextRootIndex = index -1;
                break;
            }
        }
        for (; index <= right-1; index++){
            if (arr[index] < root){
                return false;
            }
        }

        if (!isPostorder(arr, left, nextRootIndex)){
            return false;
        }

        return isPostorder(arr, nextRootIndex+1, right-1);
    }
}
