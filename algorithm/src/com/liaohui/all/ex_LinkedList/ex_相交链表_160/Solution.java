package com.liaohui.all.ex_LinkedList.ex_相交链表_160;

/**
 * @auther Mr.Liao
 * @date 2021/9/2 19:18
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;

        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else
                p1 = headB;

            if (p2 != null) {
                p2 = p2.next;
            } else
                p2 = headA;
        }
        return p1;
    }
}
