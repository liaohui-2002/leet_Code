package com.liaohui.all.ex_recursion.ex_移除链表元素_203;

import com.liaohui.commom.ListNode;

/**
 * @auther Mr.Liao
 * @date 2021/9/24 10:25
 */

/*
* 要求用递归实现
*
*
* */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
        {
            return head;
        }//出口条件
//        先对head之后的节点进行相应的删除操作
        head.next = removeElements(head.next,val);
//        再判断head是不是需要删除的结点
        return head.val == val? head.next:head;
    }

}
