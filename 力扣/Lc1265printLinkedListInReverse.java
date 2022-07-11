package 力扣;

import java.util.LinkedList;
import java.util.Stack;

public class Lc1265printLinkedListInReverse {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        for (ImmutableListNode p = head; p != null; p = p.getNext()){
            ImmutableListNode cur = p;
            stack.push(cur);
        }

        System.out.print("[");
        while (!stack.isEmpty()){
            ImmutableListNode cur = stack.pop();
            cur.printValue();
            if (!stack.isEmpty()){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}

interface ImmutableListNode{
    public void printValue();
    public ImmutableListNode getNext();
}
