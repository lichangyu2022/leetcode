package org.learn.listnode;

/**
 * 合并两个有序链表 leetcode 21
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoLists {


    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        //list2.next.next = new ListNode(4);

        mergeTwoLists(list1,list2);

        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(null == list1){
            return list2;
        }
        if(null == list2){
            return list1;
        }


        ListNode result = new ListNode(0);
        ListNode p = result;

        while (null != list1 && null != list2){

            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }

            p = p.next;
        }

        if(null != list1){
            p.next = list1;
        }

        if(null != list2){
            p.next = list2;
        }
        return result.next;
    }


}
