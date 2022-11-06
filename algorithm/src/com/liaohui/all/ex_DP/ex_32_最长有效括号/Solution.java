package com.liaohui.all.ex_DP.ex_32_最长有效括号;

/**
 * @author Mr.lh
 * @date 2022/11/6 14:36
 */

import org.junit.Test;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Solution {
    public int longestValidParentheses(String s) {
        //维护结果
        int res = 0;
        //用一个栈存  左括号的索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, start = -1; i < s.length(); i++) {
            //对字符串遍历 ，初始化start 后面会更新到第一个第一个右括号且没有左括号的位置
            //左括号 将索引入栈
            if (s.charAt(i) == '(') stack.push(i);
            else {
                //不是左括号 且栈不空
                if (!stack.isEmpty()) {
                    //弹出栈顶
                    stack.pop();
                    //弹出栈顶如果还是不空，说明已经左右括号配成了一对
                    if (!stack.isEmpty()) {
                        res = Math.max(res,i-stack.peek());
                    }else {
                        //弹出后栈空 要匹配最左边更细
                        res = Math.max(res,i-start);
                    }
                }
                else {
                    start = i;
                }
            }
        }
        return  res;
    }

    @Test
    public void test(){
        String s= ")()())";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
}
