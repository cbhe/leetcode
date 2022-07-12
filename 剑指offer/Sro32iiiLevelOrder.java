package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import utils.tree.TreeNode;

public class Sro32iiiLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;
        while (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                if (level >= ret.size()) {
                    ret.add(new ArrayList<>());
                }
                ret.get(level).add(curNode.val);
                queue.add(curNode);
            }
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.remove();
                if (level % 2 == 0) {
                    if (curNode.left != null)
                        stack.push(curNode.left);
                    if (curNode.right != null)
                        stack.push(curNode.right);
                } else {
                    if (curNode.right != null)
                        stack.push(curNode.right);
                    if (curNode.left != null)
                        stack.push(curNode.left);
                }
            }
            level++;
        }
        return ret;
    }
}
