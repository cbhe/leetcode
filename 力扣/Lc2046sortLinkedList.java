package 力扣;

import java.util.List;

public class Lc2046sortLinkedList {
    public ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = new ListNode();
        pre.next = head;

        ListNode p = head;
        while (p.next != null){
            ListNode q = p.next;
            if (q.val < 0) {
                // q 移动到 pre 后
                p.next = q.next;
                q.next = pre.next;
                pre.next = q;
            } else {
                p = p.next;
            }
        }

        return pre.next;
    }
}
