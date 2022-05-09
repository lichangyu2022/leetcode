package org.learn.leetcode;

import org.learn.entity.ListNode;

/**
 * 删除排序链表中的重复元素 leetcode 83
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class DeleteDuplicates {


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);

        deleteDuplicates(list1);

        System.out.println("");

    }



    public static  ListNode deleteDuplicates(ListNode head) {
        if(null == head){
            return head;
        }

        ListNode res = head;

        while (null != res.next){

            if(res.next.val == res.val){
                res.next = res.next.next;
            }else {
                res = res.next;
            }

        }

        return head;
    }












}