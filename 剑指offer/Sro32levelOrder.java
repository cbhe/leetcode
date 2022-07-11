package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.tree.TreeNode;

public class Sro32levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<Integer> levelQue = new LinkedList<>();
        Queue<TreeNode> nodeQue = new LinkedList<>();
        nodeQue.add(root);
        levelQue.add(0);
        List<List<Integer>> ret = new ArrayList<>();
        while (!nodeQue.isEmpty()){
            TreeNode cur = nodeQue.remove();
            int level = levelQue.remove();
            if (level >= ret.size()){
                ret.add(new ArrayList<>());
            }
            ret.get(level).add(cur.val);

            if (cur.left != null){
                nodeQue.add(cur.left);
                levelQue.add(level+1);
            }
            if (cur.right != null){
                nodeQue.add(cur.right);
                levelQue.add(level+1);
            }
        }
        return ret;
    }
}
