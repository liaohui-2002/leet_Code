package com.liaohui.all.ex_LinkedList.ex_反转链表_206;

/**
 * @auther Mr.Liao
 * @date 2021/9/2 19:37
 */


class ListNode {
    int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        if(head == null|| head.next == null)
                return head;
        while (cur != null)
        {
            ListNode temp  = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }

}
