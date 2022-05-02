package org.leetcode.learn.easy;

import org.leetcode.learn.entity.ListNode;

/**
 * 反转列表 leetcode206
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = reverseList(head);
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if(null == head){
            return null;
        }

        ListNode pre = null;
        ListNode current = head;
        while (null != current){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;

    }
}
