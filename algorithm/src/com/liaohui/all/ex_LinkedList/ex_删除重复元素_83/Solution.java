package com.liaohui.all.ex_LinkedList.ex_删除重复元素_83;


import org.junit.Test;

import java.awt.*;
import java.util.LinkedList;

/**
 * @auther Mr.Liao
 * @date 2021/9/2 18:54
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode p = head;

        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        Solution s1 = new Solution();

    }

}
