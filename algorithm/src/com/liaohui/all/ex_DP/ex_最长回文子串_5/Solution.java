package com.liaohui.all.ex_DP.ex_最长回文子串_5;

import javafx.scene.layout.CornerRadii;

/**
 * @auther Mr.Liao
 * @date 2021/9/4 10:24
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        //状态容器
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int max = 1, start = 0;//记录回文串首尾 index
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len - 1 && i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i <3)
                        dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i + 1][j-1];//状态转移方程
                    }
                }
                if (dp[i][j] && j - i + 1 > max)//j-i +1 计算步长常用式子
                {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "babad";
        System.out.println(s.longestPalindrome(s1));
        String s2 = "bb";
        System.out.println(s.longestPalindrome(s2));

        System.out.println(s1.substring(2,5));
    }
}
