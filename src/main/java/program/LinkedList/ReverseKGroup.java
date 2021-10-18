package program.LinkedList;

/**
 * @Author tangkai009
 * @Date 2021-04-16
 * @description
 */
public class ReverseKGroup {


    public static ListNode reverseKGroup(ListNode head,int k){

        //Mark
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a,b;
        a = head ; b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode listNode = reverseK(a, b);

        a.next = reverseKGroup(b,k);

        return listNode;

    }

    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    public static ListNode reverseK(ListNode a,ListNode b){

        ListNode pre = null ; ListNode cur = a;
        while(a != b){
            cur = a.next;
            a.next = pre;
            pre = a;
            a = cur;
        }
//        cur.next = pre;
        return pre;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

//        ListNode listNode = reverseK(listNode1, listNode7);


        ListNode listNode = reverseKGroup(listNode1, 3);
        while(listNode != null){

            System.err.print(listNode.val);
            listNode = listNode.next;
        }


    }

}
