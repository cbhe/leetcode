package 面试题;

import utils.tree.TreeNode;

public class Q0402sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return create(nums, 0, nums.length-1);
    }

    private TreeNode create(int[] nums, int left, int right){
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, left, mid-1);
        root.right = create(nums, mid+1, right);
        return root;
    }
}
