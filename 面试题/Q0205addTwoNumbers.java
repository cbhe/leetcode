package 面试题;

import utils.list.ListNode;

public class Q0205addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int inc = 0;
        while(l1 != null || l2 != null){
            ListNode curNode = new ListNode(0);
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = inc + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null){
                sum = inc + l1.val;
                l1 = l1.next;
            } else if (l2 != null){
                sum = inc + l2.val;
                l2 = l2.next;
            }

            if (sum >= 10){
                inc = 1;
                sum = sum - 10;
            } else {
                inc = 0;
            }
            curNode.val = sum;

            p.next = curNode;
            p = p.next;
        }

        if (inc != 0){
            p.next = new ListNode(inc);
        }

        return head.next;
    }
}
