package com.liaohui.all.ex_DP.ex_无重复最长字串;

import org.junit.Test;

import java.util.HashSet;

/**
 * @auther Mr.Liao
 * @date 2021/9/12 20:27
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是wke"，所以其长度为 3。
 *    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串
 *

 */
public class Solution {
    public static  int lengthOfLongestSubstring(String s) {
        //corner case
        if (s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int max = 1;
        int start = 0, end = 0;
        while (end < s.length()) {
            char c_e = s.charAt(end);
            if (set.contains(c_e)) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(c_e);
                max = Math.max(max, set.size());
                end++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int a;
        String s = "pwwkew";
        a = Solution.lengthOfLongestSubstring(s);

        System.out.println(a);
    }
}
