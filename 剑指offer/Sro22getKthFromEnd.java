package 剑指offer;

import utils.list.ListNode;

public class Sro22getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p = head, q = head;
        for (int i = 0; i< k; i++){
            p = p.next;
        }
        while (p != null){
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
