package 力扣;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.tree.TreeNode;

public class Lc662widthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodeQue = new LinkedList<>();
        Queue<Integer> levelQue = new LinkedList<>();
        Queue<Integer> indexQue = new LinkedList<>();
        nodeQue.add(root);
        levelQue.add(0);
        indexQue.add(0);

        List<List<Integer>> indexList = new ArrayList<>();
        while (!nodeQue.isEmpty()){
            TreeNode curNode = nodeQue.remove();
            int curLevel = levelQue.remove();
            int curIndex = indexQue.remove();

            if (curLevel >= indexList.size()){
                indexList.add(new ArrayList<>());
            }
            indexList.get(curLevel).add(curIndex);

            if (curNode.left != null) {
                nodeQue.add(curNode.left);
                levelQue.add(curLevel+1);
                indexQue.add(2 * curIndex + 1);
            }
            if (curNode.right != null){
                nodeQue.add(curNode.right);
                levelQue.add(curLevel+1);
                indexQue.add(2 * curIndex + 2);
            }
        }

        int ret = 0;
        for (List<Integer> list: indexList){
            int min = list.get(0);
            int max = list.get(list.size()-1);
            ret = Math.max(max-min+1, ret);
        }

        return ret;
    }
}
