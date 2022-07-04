package utils.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        this.val = x;
    }

    public TreeNode(int[] nodeArrays){
        Queue<TreeNode> queue = new LinkedList<>();
        this.val = nodeArrays[0];
        queue.add(this);

        for (int i = 1; i< nodeArrays.length; i=i+2){
            TreeNode curNode = queue.remove();
            curNode.left = new TreeNode(nodeArrays[i]);
            queue.add(curNode.left);
            if (i+1 < nodeArrays.length){
                curNode.right = new TreeNode(nodeArrays[i+1]);
                queue.add(curNode.right);
            }
        }
    }
}
