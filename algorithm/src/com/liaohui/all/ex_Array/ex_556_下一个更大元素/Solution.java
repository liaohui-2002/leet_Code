package com.liaohui.all.ex_Array.ex_556_下一个更大元素;

/**
 * @author Mr.lh
 * @date 2022/11/17 13:26
 */

/**
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 *
 * 输入：n = 21
 * 输出：-1
 */
public class Solution {
    public int nextGreaterElement(int n) {
        //先把n弄成字符数组 方便处理
        char[] nums = Integer.toString(n).toCharArray();

        //思路先找到第一个升序的位置 从右往左探索
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        //序列全降序 说明已经最大
        if(i<0) return  -1;

        //用j来找到 nums[i] 右边第一个比nums[i]大的数字 这里显然就是仅比nums[i]大
        int j = nums.length-1;
        while(j>=0 && nums[i]>=nums[j]) j--;
        //找到后swap
        swap(nums,i,j);
        //右边已经全部降序 改为升序
        reverse(nums,i+1,nums.length-1);
        //做返回处理
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    private void reverse(char[] nums, int start, int end) {
        while (start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }
}
