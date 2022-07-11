package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class Sro36treeToDoublyList {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        List<Node> nodeList = new ArrayList<>();
        midRootDfs(root, nodeList);
        Node ret = nodeList.get(0);
        for (int i = 0; i<nodeList.size()-1;i++){
            Node p = nodeList.get(i);
            Node q = nodeList.get(i+1);
            p.right = q;
            q.left = p;
        }
        Node tail = nodeList.get(nodeList.size()-1);
        tail.right = ret;
        ret.left = tail;

        return ret;
    }

    private void midRootDfs(Node root, List<Node> ret){
        if (root.left == null && root.right == null){
            ret.add(root);
            return;
        }
        if (root.left != null) midRootDfs(root.left, ret);
        ret.add(root);
        if (root.right != null) midRootDfs(root.right, ret);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
