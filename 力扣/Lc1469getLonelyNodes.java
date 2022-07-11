package 力扣;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.tree.TreeNode;

public class Lc1469getLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if (cur.left != null && cur.right == null) ret.add(cur.left.val);
            if (cur.left == null && cur.right != null) ret.add(cur.right.val);

            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }

        return ret;
    }
}
