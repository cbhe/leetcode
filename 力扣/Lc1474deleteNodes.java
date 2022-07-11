package 力扣;

public class Lc1474deleteNodes {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p = pre;
        while (p.next != null){

            // 跳过 m 个节点
            for (int i = 0; i< m; i++){
                if (p.next != null){
                    p = p.next;
                } else {
                    break;
                }
            }

            // 删除 n 个节点
            for (int i = 0; i< n; i++){
                if (p.next != null){
                    p.next = p.next.next;
                } else {
                    break;
                }
            }
        }
        return head;
    }
}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
