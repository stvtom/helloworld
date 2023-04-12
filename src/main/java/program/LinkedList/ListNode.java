package program.LinkedList;

/**
 * @Author tangkai009
 * @Date 2021-04-14
 * @description
 */
public class ListNode {

    public ListNode next;

    public int val;

    public ListNode(int val){
        this.val = val;
    }


    public static void main(String[] args) {

        ListNode listNodeList = getNodeList();

        while(listNodeList !=null){

            System.err.println(listNodeList.val);

            listNodeList = listNodeList.next;
        }
    }
    /**
     * 构造链表
     * @return
     */
    public static ListNode getNodeList(){

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

        return listNode1;
    }
}
