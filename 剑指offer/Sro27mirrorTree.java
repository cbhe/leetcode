package 剑指offer;

import utils.tree.TreeNode;

public class Sro27mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root){
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
