package program.LinkedList;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @Author tangkai009
 * @Date 2021-04-24
 * @description
 */
public class E37FirstCommonNodesInLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA =  0;

        int lengthB =  0;

        if (headA == null || headB == null){
            return null;
        }

        ListNode a  = headA ; ListNode b = headB;

        while(a != null){
            lengthA ++;
            a = a.next;
        }
        while(b != null){
            lengthB ++;
            b = b.next;
        }

        if (lengthA - lengthB > 0){

            int len = lengthA - lengthB;

            for (int i = 0; i < len; i++) {

                headA = headA.next;
            }
        }else {

            int len = lengthB - lengthA;

            for (int i = 0; i < len; i++) {

                headB = headB.next;
            }
        }

        while(headA != null && headB != null){

            if (headA .equals(headB) ){
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }


        return null;
    }



}
