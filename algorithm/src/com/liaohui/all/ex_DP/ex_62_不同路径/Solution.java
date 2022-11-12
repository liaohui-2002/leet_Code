package com.liaohui.all.ex_DP.ex_62_不同路径;

/**
 * @author Mr.lh
 * @date 2022/11/12 15:39
 */
//dp经典提
public class Solution {
    public int uniquePaths(int m, int n) {
        //定义二维数组dp[i][j] 记录每个单元格的状态
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
