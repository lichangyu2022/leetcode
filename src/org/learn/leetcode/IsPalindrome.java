package org.learn.leetcode;

import org.learn.entity.ListNode;


/**
 * leetcode 回文链表  234
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        if(null == head){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
        }


        //是否为奇数，如果是，右移一位
        if(null != fast){
            slow = slow.next;
        }

        //反转过后，可判断是否是回文
        slow = ReverseList.reverseList(slow);
        fast = head;
        while (null != slow){
            if(fast.val != slow.val){
                return false;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return true;

    }
}