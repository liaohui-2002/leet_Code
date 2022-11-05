package com.liaohui.all.ex_Array.ex_颜色分类_75;

import java.util.Arrays;

/**
 * @auther Mr.Liao
 * @date 2021/9/19 15:53
 */

//给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
    /*
    * 你可以不使用代码库中的排序函数来解决这道题吗？
你能想出一个仅使用常数空间的一趟扫描算法吗？
*/
public class Solution {
    private void swap(int[] arr,int index1,int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums,i,p2);
            }
            if (nums[i] == 0) {
               swap(nums,i,p0);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,2};
        System.out.println("变化前"+Arrays.toString(arr));
        Solution s = new Solution();
        s.sortColors(arr);
        System.out.println("变化后"+Arrays.toString(arr));
    }
}
