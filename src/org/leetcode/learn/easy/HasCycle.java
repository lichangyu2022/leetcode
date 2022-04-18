package org.leetcode.learn.easy;

import org.leetcode.learn.entity.ListNode;

/**
 * leetcode141 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。

 *
 */
public class HasCycle {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = head.next.next;

        System.out.println(hasCycle(head));

    }




    public static boolean hasCycle(ListNode head) {

        if(null == head){
            return false;
        }


        ListNode slowNode = head;
        ListNode fastNode = head;

        while(null != fastNode.next && null != fastNode.next.next){


            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if(slowNode == fastNode){
                return true;
            }

        }

        return false;



    }

}
