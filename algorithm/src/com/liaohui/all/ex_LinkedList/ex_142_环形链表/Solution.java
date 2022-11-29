package com.liaohui.all.ex_LinkedList.ex_142_环形链表;

/**
 * @author Mr.lh
 * @date 2022/11/29 15:21
 */

import com.liaohui.commom.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //判断环 双指针
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next !=null){
            fast  =fast.next.next;
            slow = slow.next;
            //快慢指针 快慢指针相遇 说明有环
            if(fast == slow){
                //一段数学推导 参考平板笔记 起点到环的入口距离等于环里相遇点到环入口的后半段距离
                ListNode index1 =  fast;
                ListNode index2 = head;
                while(index1 != index2){
                    index1 =  index1.next;
                    index2 = index2.next;
                }
                //这里是找环的起点 也就是index1 和 index2相遇的位置
                return index1;
            }
        }
        return null;
    }
}
