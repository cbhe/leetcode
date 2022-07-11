package 力扣;

public class Lc369plusOne {
    public ListNode plusOne(ListNode head) {
        head = reverseList(head);
        head = plusOne1(head);
        head = reverseList(head);
        return head;
    }

    private ListNode plusOne1(ListNode head){
        int inc = 0;
        ListNode tail = head;
        for (ListNode p = head; p != null; p = p.next){
            int sum = 0;
            if (p == head) {
                 sum = p.val + 1 + inc;
            } else {
                sum = p.val + inc;
            }
            if (sum >= 10){
                inc = 1;
                sum = sum - 10;
            } else {
                inc = 0;
            }
            p.val = sum;
            tail = p;
        }
        if (inc == 1){
            tail.next = new ListNode(1);
        }
        return head;
    }
    private ListNode reverseList(ListNode head){

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p = head;
        while (p.next!=null){
            ListNode q = p.next; // 要操作的点和前一个节点用 q 和 p 标记
            p.next = q.next; // 断开 q 左边
            q.next = pre.next; // 重置 q 右边
            pre.next = q; // 重置 q 左边
        }
        return pre.next;
    }
}
