package org.learn.listnode;

/**
 * leetcode 160 相交链表
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *

 */
public class GetIntersectionNode {

    public static void main(String[] args) {


        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next =  list1.next;

        System.out.println(list1.next);
        System.out.println(getIntersectionNode(list1, list2));
        System.out.println(getIntersectionNode2(list1, list2));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(null == headA || null == headB){
            return null;
        }

        ListNode hA = headA;
        ListNode hB = headB;

        while (hA != hB){

            hA = null == hA ? headB : hA.next;
            hB = null == hB ? headA : hB.next;

        }

        return hA;



    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if(null == headA || null == headB){
            return null;
        }

        int lA = 0;
        int lB = 0;
        int index = 0;

        ListNode hA = headA;
        ListNode hB = headB;

        while (null != hA){
            lA++;
            hA = hA.next;
        }

        while (null != hB){
            lB++;
            hB = hB.next;
        }


        if(lA > lB){
            index = lA - lB;
            hA = headA;
            hB = headB;
        }else {
            index = lB - lA;
            hA = headB;
            hB = headA;
        }

        for(int i = 0;i < index; i++){
            hA = hA.next;
        }

        while (hA != hB){

           hA = hA.next;
           hB = hB.next;

        }

        return hA;



    }


}
