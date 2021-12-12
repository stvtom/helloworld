package program.LinkedList;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @Author tangkai009
 * @Date 2021-04-24
 * @description
 */
public class DeleteNode {


    public ListNode deleteNode(ListNode head, int val) {

        if (head == null){
            return null;
        }
        ListNode a = head;
        int count  = 0;
        while(a != null){
            count++;
            a = a.next;
        }
        int offsize = 0;

        while(head.val == val){

            head = head.next;
            offsize++;
        }
        ListNode begin = head;


        while(begin.next != null){

            if (begin.next.val == val){
                begin.next = begin.next.next;
            }else {
                begin = begin.next;
            }
        }

        return head;
    }
}
