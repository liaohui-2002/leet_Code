package com.liaohui.all.ex_LinkedList.ex_k个一组翻转链表_25;

/**
 * @auther Mr.Liao
 * @date 2022/9/24 19:43
 */

class ListNode {
    int val;
    ListNode next;

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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
       //定义一个假结点，方便返回最后的结果
        ListNode dummy = new ListNode(0);
        //该节点指向链表头
        dummy.next = head;

        //用两个指针来标志每个需要反转的组 pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;

        pre.next = head;


        //循环反转
        while(end.next != null){
            //按k寻找每个end
            for (int i = 0; i <k &&end != null ; i++) {
                //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
                    end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end == null){
                break;
            }
            //先记录下end.next,方便反转后连接链表
            ListNode next  = end.next;
            //断开链表
            end.next =null;
            //记录需要反转组别的起点
            ListNode start = pre.next;
            //反转链表 pre.next指向翻转后的链表
            pre.next = reverseList(start);
            //重新连接链表 此时的start已经是被反转链表的尾节点
            start.next = next;
            //反转完成  重置pre 和end
            pre=start;
            end =start;
        }
            return dummy.next;

    }

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