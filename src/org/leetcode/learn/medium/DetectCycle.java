package org.leetcode.learn.medium;

import org.leetcode.learn.entity.ListNode;

/**
 * leetcode 142 环形链表二
 *
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 */
public class DetectCycle {




    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = head.next.next;

        System.out.println(head.next.next);
        System.out.println(hasCycle(head));

    }




    public static ListNode hasCycle(ListNode head) {

        if(null == head){
            return null;
        }

        boolean isEx = false;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(null != fastNode.next && null != fastNode.next.next){


            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if(slowNode == fastNode){
                isEx = true;
                break;
            }

        }

        if(isEx){

            slowNode = head;

            while (slowNode != fastNode){

                slowNode = slowNode.next;
                fastNode = fastNode.next;

            }
            return slowNode;

        }

        return null;



    }


}
