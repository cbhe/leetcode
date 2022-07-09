package 力扣;

import utils.tree.TreeNode;

public class Lc654constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTree(nums, 0, nums.length-1);
    }

    private TreeNode createTree(int[] nums, int left, int right){
        if (left > right){
            return null;
        }

        int max = -1;
        int index = -1;
        for (int i = left; i<=right; i++){
            if (nums[i] > max){
                max = Math.max(max, nums[i]);
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = createTree(nums, left, index-1);
        root.right = createTree(nums, index+1, right);

        return root;
    }
}
