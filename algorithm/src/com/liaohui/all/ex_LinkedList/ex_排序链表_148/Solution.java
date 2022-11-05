package com.liaohui.all.ex_LinkedList.ex_排序链表_148;

import com.liaohui.commom.ListNode;

/**
 * @auther Mr.Liao
 * @date 2021/9/16 20:53
 */
//归并
public class Solution {
    /**
     * 归并排序，返回排序好的头结点
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中间的节点
        ListNode mid = findMid(head);
        // 右边进行排序
        ListNode right = sortList(mid.next);
        // 从中间断开
        mid.next = null;
        // 左边进行排序
        ListNode left = sortList(head);
        // 合并排好序的左右部分
        ListNode mergedNode = mergeTwoLists(left, right);
        return mergedNode;
    }

    /**
     * 深入理解jVM
     * 合并两个排好序的链表
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        //左右两个已排序的链表合并成一个链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left == null) {
            tail.next = right;
        } else {
            tail.next = left;
        }
        return dummy.next;
    }

    /**
     * 合并两个有序的链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            // l1 作为头结点，l1.next为 l1 剩下的节点和 l2合并的头结点
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            // 同上
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 返回链表的中点
     * @param head
     * @return
     */
    public ListNode findMid(ListNode head){
        // 慢指针
        ListNode slow = head;
        // 快指针，这里一定要是head.next，不能是head，不然出错
        ListNode fast = head.next;
        // 快指针走到尾部，则慢指针走到中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

