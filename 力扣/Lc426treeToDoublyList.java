package 力扣;

import java.util.ArrayList;
import java.util.List;

public class Lc426treeToDoublyList {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        List<Node> list = new ArrayList<>();
        middleRoot(root, list);

        Node head = list.get(0);
        for (int i = 0; i<list.size()-1; i++){
            Node p = list.get(i);
            Node q = list.get(i+1);
            p.right = q;
            q.left = p;
        }

        Node tail = list.get(list.size()-1);
        tail.right = head;
        head.left = tail;
        return head;
    }

    private void middleRoot(Node root, List<Node> ret){
        if (root == null) return;

        middleRoot(root.left, ret);
        ret.add(root);
        middleRoot(root.right, ret);
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

