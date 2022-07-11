package 力扣;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import utils.tree.TreeNode;

public class Lc652findDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Integer[]{1,2,3,4,null,2,4,null,null,4});
        List<TreeNode> ret = new Lc652findDuplicateSubtrees().findDuplicateSubtrees(root);
        System.out.println(ret);
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            String id = bfsID(cur);
            if (!countMap.containsKey(id)){
                countMap.put(id, 0);
            }
            countMap.put(id, countMap.get(id) + 1);
            if (countMap.get(id) == 2){
                ret.add(cur);
            }
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return ret;
    }

    private String bfsID(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> valList = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if (cur == null){
                valList.add(null);
                continue;
            }
            valList.add(String.valueOf(cur.val));
            queue.add(cur.left);
            queue.add(cur.right);
        }

        return String.join(",", valList);
    }
}
