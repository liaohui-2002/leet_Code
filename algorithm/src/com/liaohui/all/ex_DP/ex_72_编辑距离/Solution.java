package com.liaohui.all.ex_DP.ex_72_编辑距离;

/**
 * @author Mr.lh
 * @date 2022/11/12 15:58
 */


import org.junit.Test;

/**
 * dp困难题
 */
public class Solution {
    public int minDistance(String a, String b) {
        //同a , b两个字符数组  f[i,j]表示a的前i个字符要和b的前j个字符匹配 所需要操作的次数
        int n = a.length(),m = b.length();
        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }
        a = ' '+a;
        b = ' '+b;
        //定义状态数组
        int[][] dp = new int[n+1][m+1];
        //边界初始化
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <m+1 ; i++) {
            dp[0][i] = i;
        }
        //计算dp中的所有值
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[n][m];
    }

    @Test
    public void test1(){
        String s1 = "horse",s2 = "ros";
        int i = minDistance(s1, s2);
        System.out.println(i);
    }
}
