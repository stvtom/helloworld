package program.LeetCode;

import program.LinkedList.ListNode;

/**
 * @Author tangkai009
 * @Date 2023-04-12
 * @description
 */
public class L02AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先反转链表

        ListNode revert1 = revert(l1);

        ListNode revert2 = revert(l2);

        if (revert1 == null ){
            return revert2;
        }
        if (revert2 == null){
            return revert1;
        }

        ListNode cur = new ListNode(0);

        ListNode head = cur;

        int carry = 0 ;
        while(revert1.next != null && revert2.next != null){

            int x = revert1 != null ? revert1.val : 0;

            int y = revert2 != null ? revert2.val : 0;

            int sum = x+y + carry;

            carry = sum / 10;

            int val = sum % 10;

            cur.next = new ListNode(val);

            cur = cur.next;

            if (revert1.next !=null){
                revert1 = revert1.next;
            }
            if (revert2.next !=null){
                revert2 = revert2.next;
            }
        }

        if (carry > 0){
            cur.next = new ListNode(carry);
        }

        return head.next;

    }


    public static ListNode revert(ListNode head){

        if (head == null || head.next == null) {
            return head;
        }
        //A      B     C

        //beg    end

        ListNode beg  = head;

        ListNode end = head.next;

        while (end.next == null){

            end.next = head;
            head = end;
            end = beg.next;

        }

        return head;
    }

    public static ListNode getNodeList(){

        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        return listNode1;
    }

    public static ListNode getNodeList1(){

        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        return listNode1;
    }

    public static void main(String[] args) {

        ListNode nodeList = getNodeList();

        ListNode revert = revert(nodeList);

        while (revert != null){
            System.err.println(revert.val);
            revert = revert.next;
        }
    }
}

