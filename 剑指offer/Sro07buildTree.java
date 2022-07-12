package 剑指offer;

import utils.tree.TreeNode;

public class Sro07buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        return createTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode createTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if (preLeft > preRight) return null;
        if (preLeft == preRight) return new TreeNode(preorder[preLeft]);

        int rootVal = preorder[preLeft];
        int inorderRootPos = inLeft;
        while (inorderRootPos<=inRight && inorder[inorderRootPos]!=rootVal){
            inorderRootPos++;
        }

        int preorderLeftEnd = (preLeft + 1) + (inorderRootPos - inLeft) - 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = createTree(preorder, preLeft+1, preorderLeftEnd, inorder, inLeft, inorderRootPos-1);
        root.right = createTree(preorder, preorderLeftEnd+1, preRight, inorder, inorderRootPos+1, inRight);

        return root;
    }
}
