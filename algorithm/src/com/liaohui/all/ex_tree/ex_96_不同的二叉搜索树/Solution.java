package com.liaohui.all.ex_tree.ex_96_不同的二叉搜索树;

/**
 * @author Mr.lh
 * @date 2022/11/5 16:32
 */
public class Solution {
    public int numTrees(int n) {
//维护G(n) 和f(i)  f（i） 表示以为i为根节点的二叉搜索树个数  G(n) 表示n个节点二叉搜索树的总数
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1]= 1;
        //G（n） =
        //这里循环条件是等于 因为 维护的dp多了一个没有节点的情况  总共有n+1个
        for (int i = 2; i <=n ; i++) {//外层表示 G(2) 算到 G（n）
            for (int j = 0; j <=i ; j++) {
                dp[i] += dp[j-1]*dp[i-j]; //比如 G(0) * G(1) + G（1）*G(0)
            }
        }
        return dp[n];
    }

}
