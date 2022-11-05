package com.liaohui.all.ex_Array.ex_寻找两个正序数组的总位数_4;

import java.util.Arrays;

/**
 * @auther Mr.Liao
 * @date 2021/9/12 21:06
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i];
        }
        for (int i = 0; i <nums2.length ; i++) {
            arr[nums1.length+i] = nums2[i];
        }
        Arrays.sort(arr);
        if(arr.length%2==0)
        {
            double temp = (double) (arr[arr.length/2-1]+arr[arr.length/2])/2;
            return temp;
        }
        else
        {
            double a = arr[arr.length/2];
            return a;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        double a = Solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(a);
    }
}
