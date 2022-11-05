package com.liaohui.all.ex_LinkedList.ex_合并升序链表_23;

import com.liaohui.commom.ListNode;

/**
 * @auther Mr.Liao
 * @date 2021/9/22 8:10
 */
/**
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

//思路 分治  重复两两合并的过程
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r)
    {
        if(l == r)
        {
            return lists[l];
        }
        if(l>r)
        {
            return null;
        }
        int mid = l + (r- l)>>1;
        ListNode left = merge(lists,l,mid);
        ListNode right = merge(lists, mid+1, r);
        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6,null);
        ListNode node4 = new ListNode(4,node6);
        ListNode node3 = new ListNode(3,node4);

        ListNode node2 = new ListNode(2,null);
        ListNode node1 = new ListNode(1,node2);

        ListNode[] lists = {node3,node1};
        Solution s = new Solution();
        ListNode cur = s.mergeKLists(lists);
        System.out.println(cur);
    }
}
