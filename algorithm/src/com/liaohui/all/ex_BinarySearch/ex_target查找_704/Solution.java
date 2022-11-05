package com.liaohui.all.ex_BinarySearch.ex_target查找_704;

/**
 * @auther Mr.Liao
 * @date 2021/9/12 21:54
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start+1 < end)
        {
//            mid = (start+end)/2;错误写法
            mid = start + (end - start)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end =mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == end) return end;
        return -1;
    }
}
