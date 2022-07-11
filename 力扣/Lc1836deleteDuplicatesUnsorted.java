package 力扣;

import java.util.HashMap;
import java.util.Map;

public class Lc1836deleteDuplicatesUnsorted {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null || head.next == null) return head;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (ListNode p = head; p != null; p = p.next){
            if (countMap.containsKey(p.val)){
                countMap.put(p.val, countMap.get(p.val)+1 );
            } else {
                countMap.put(p.val, 1);
            }
        }

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p = pre;
        while (p.next != null){
            if (countMap.get(p.next.val) > 1){
                // 删除 p.next
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return pre.next;
    }
}
