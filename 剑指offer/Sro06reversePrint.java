package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utils.list.ListNode;

public class Sro06reversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        if (head.next == null) return new int[]{head.val};

        head = reverseList(head);
        int len = 0;
        for (ListNode p = head; p != null; p = p.next){
            len++;
        }

        int[] ret = new int[len];
        int index = 0;
        for (ListNode p = head; p!= null; p = p.next){
            ret[index++] = p.val;
        }

        return ret;
    }
    private ListNode reverseList(ListNode head){
        ListNode pre = new ListNode();
        pre.next = head;
        while (head.next != null){
            ListNode p = head.next;
            head.next = p.next;
            p.next = pre.next;
            pre.next = p;
        }
        return pre.next;
    }
}
