package com.liaohui.all.ex_DP.ex_最大子序和_53;

/**
 * @auther Mr.Liao
 * @date 2021/9/2 22:46
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 */



//重点在于列出状态转移方程
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.max(arr[i - 1] + nums[i], nums[i]);
            max = Math.max(arr[i], max);
        }
        return max;

        /*改进版
        * int max = nums[0];
        int sum = nums[0];
        for(int i = 1;i < nums.length;i++)
        {
            sum = Math.max(sum+nums[i],nums[i]);
            if(sum>max) max = sum;
        }
        return max;
        *
        *
        *
        *
        * */
    }
}
