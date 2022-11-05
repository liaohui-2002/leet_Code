package com.liaohui.all.ex_Array.ex_验证回文串_125;

/**
 * @auther Mr.Liao
 * @date 2021/9/4 10:42
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
//双指针
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;//特殊情况
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i <= j && Character.isLetterOrDigit(s.charAt(i)))//注意边界条件
            {
                i++;
            }
            while (i <= j && Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i <= j && Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
