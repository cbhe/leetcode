package 力扣;

public class Lc878middleNode {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        int len = 0;
        for (ListNode p = head; p !=  null; p = p.next){
            len++;
        }
        int midIndex = len / 2;

        int i = 0;
        for (ListNode p = head; p != null; p = p.next){
            if (i == midIndex){
                return p;
            } else {
                i++;
            }
        }

        return null;
    }
}
