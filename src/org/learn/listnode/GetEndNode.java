package org.learn.listnode;

/**
 * 剑指offer 22
 * 获取链表中倒数第k个节点
 *
 */
public class GetEndNode {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(getEndNode(head,1));
    }

    private static Integer getEndNode(ListNode head, int k) {

        if(null == head){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 1; i < k; i++){
            if(null != fast){
                fast = fast.next;
            }else {
                return null;
            }
        }

        while (null != fast.next){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;

    }
}
