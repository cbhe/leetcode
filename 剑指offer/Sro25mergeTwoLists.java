package 剑指offer;

import utils.list.ListNode;

public class Sro25mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p = l1, q = l2, pre = new ListNode(), tail = pre;
        while (p!= null && q != null){
                if (p.val <= q.val){
                    tail.next = p;
                    tail = tail.next;
                    p = p.next;
                } else {
                    tail.next = q;
                    tail = tail.next;
                    q = q.next;
                }
        }
        if (p != null) tail.next = p;
        if (q != null) tail.next = q;

        return pre.next;
    }
}
