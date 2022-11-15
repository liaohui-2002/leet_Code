package com.liaohui.all.ex_DP.ex_198_打家劫舍;

/**
 * @author Mr.lh
 * @date 2022/11/5 15:56
 * 打家劫舍 dp经典问题
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n== 0) return 0;
        //写状态容器
        int[] R = new int[n];
        int[] NR = new int[n];
        //初始化
        //第一个抢 就是第一个房间的值
        R[0] = nums[0];
        NR[0] = 0;//第一个房间不抢 0
        //状态转移
        for (int i = 0; i < n; i++) {
            R[i] = nums[i]+NR[i-1];
            NR[i] = Math.max(R[i-1],NR[i-1]);//当前房子不抢，那么当前最大收益就是前一个房子抢或者不抢的最大值
        }
        return Math.max(R[n-1],NR[n-1]);
    }
}
