package 剑指offer;

import utils.list.ListNode;

public class Sro24reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        pre.next = head;

        while(head.next != null){
            ListNode p = head.next;
            head.next = p.next;
            p.next = pre.next;
            pre.next = p;
        }

        return pre.next;
    }
}
