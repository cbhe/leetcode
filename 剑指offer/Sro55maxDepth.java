package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import utils.tree.TreeNode;

public class Sro55maxDepth {
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.add(root);
        int ret = 0;
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            ret = cur.val;
            if (cur.left != null){
                cur.left.val = ret + 1;
                queue.add(cur.left);
            }
            if (cur.right != null){
                cur.right.val = ret+1;
                queue.add(cur.right);
            }
        }
        return ret;
    }
}
