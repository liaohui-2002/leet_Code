package com.liaohui.all.ex_DP.ex_正则表达式匹配_10;

/**
 * @auther Mr.Liao
 * @date 2022/10/14 10:45
 */

/*
*
* 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。


示例 1：

输入：s = "aa", p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。
示例 2:

输入：s = "aa", p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例3：

输入：s = "ab", p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

* */
/*public class Solution {
    public boolean isMatch(String s, String p) {
        //方法一：递归回溯
        //若p为空
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //查看首元素是否一致
        boolean first_match = !s.isEmpty() && ( s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //如果p的下一个字符是*
        if(p.length()>=2 && p.charAt(1) == '*'){
            return isMatch(s,p.substring(2)) || (first_match && isMatch(s.substring(1),p));
        }
        else {
            //普通情况
            return first_match && isMatch(s.substring(1),p.substring(1));
        }
    }
}*/
public class Solution {
    public boolean isMatch(String s, String p) {
        //方法二：动态规划
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int j = 2; j <= p.length() ; j++) {
            dp[0][j] = p.charAt(j-1) =='*' && dp[0][j-2];
        }

        for (int i = 0; i <s.length() ; i++) {
            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '*'){
                    dp[i+1][j+1] = dp[i+1][j-1] || first_match(s,p,i,j-1) &&dp[i][j+1];
                }
                else {
                    dp[i+1][j+1] = first_match(s,p,i,j) && dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];

    }
    public boolean first_match(String s,String p,int i,int j){
        return s.charAt(i) == p.charAt(j) || p.charAt(j) =='.';
    }
}