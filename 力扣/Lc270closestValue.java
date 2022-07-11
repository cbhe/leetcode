package 力扣;

import utils.tree.TreeNode;

public class Lc270closestValue {
    public int closestValue(TreeNode root, double target) {
        int leftInt = Integer.MIN_VALUE;
        boolean hasLeft = false;
        int rightInt = Integer.MAX_VALUE;
        boolean hasRight = false;

        TreeNode p = root;
        while (p != null){
            if (p.val < target){
                leftInt = p.val;
                hasLeft = true;
                p = p.right;
            } else {
                rightInt = p.val;
                hasRight = true;
                p = p.left;
            }
        }
        if (!hasLeft){
            return rightInt;
        }
        if (!hasRight){
            return leftInt;
        }
        if (Math.abs(leftInt-target) < Math.abs(rightInt-target)){
            return leftInt;
        } else {
            return rightInt;
        }
    }
}
