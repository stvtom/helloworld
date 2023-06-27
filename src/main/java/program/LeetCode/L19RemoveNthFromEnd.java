package program.LeetCode;

import program.LinkedList.ListNode;

/**
 * @Author tangkai009
 * @Date 2023-04-22
 * @description
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class L19RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null){
            return head;
        }

        ListNode a = head;

        ListNode b = head;

        for (int i = 0; i <= n; i++) {
            if (a != null) {
                a = a.next;
            }
        }
        while (a != null){
            a = a.next;
            b = b.next;
        }

        b.next = b.next.next;

        return head;
    }
}
