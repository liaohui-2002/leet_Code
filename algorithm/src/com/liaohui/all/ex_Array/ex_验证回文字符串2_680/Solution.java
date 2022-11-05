package com.liaohui.all.ex_Array.ex_验证回文字符串2_680;

/**
 * @auther Mr.Liao
 * @date 2021/9/4 11:05
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                //不是相同的char
                return helper(s, i + 1, j) || helper(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean helper(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                //不是相同的char
                return false;
            }
        }
        return true;
    }
}
