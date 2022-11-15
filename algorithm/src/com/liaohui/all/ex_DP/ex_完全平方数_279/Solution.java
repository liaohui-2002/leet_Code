package com.liaohui.all.ex_DP.ex_完全平方数_279;

import org.junit.Test;

/**
 * @author Mr.lh
 * @date 2022/11/15 19:27
 */
public class Solution {
    public int numSquares(int n) {
        //思路  DP  dp[n]表是 n所需的最小平方数的数量
        //状态容器
        int[] dp = new int[n+1];
        //初始化
        dp[0] = 0;
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <=(int)Math.sqrt(i) ; j++) {
                //状态更新方程
//                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                dp[i]  =  dp[i] == 0 ? dp[i-j*j]+1:Math.min(dp[i],dp[i-j*j]+1);

            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        int i = numSquares(12);
        System.out.println(i);
    }
}
