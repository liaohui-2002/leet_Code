package com.liaohui.all.ex_Array.ex_33_搜索旋转排序数组;

import org.junit.Test;

/**
 * @author Mr.lh
 * @date 2022/11/12 14:26
 */
public class Solution {
    public int searchRange(int[] nums, int target) {
        //使用二分搜索 -- 变种
        return searchHelper(nums,0,nums.length-1,target);
    }

    //具体实现
    private int searchHelper(int[] nums,int left,int right,int target) {
        if(left>right) return -1;
        int mid = (left+right)/2;
        //维护三个量  即三个观测点
        int leftValue = nums[left];
        int midValue = nums[mid];
        int rightValue =  nums[right];
        //找到的情况
        if(leftValue == target) return left;
        if(midValue == target) return mid;
        if(rightValue == target) return right;

        //根据端点数据判断哪边是有序的
        if(leftValue < midValue){//左半边有序
            //若目标值在有序区间范围内，搜索有序侧，否则搜索无需侧
            if(target>leftValue && target < midValue)
                return searchHelper(nums,left+1,mid-1,target);
            else
                return searchHelper(nums,mid+1,right,target);
        }else {
            //右侧有序
            //右侧有序且target在有序范围内
            if(target>midValue && target<rightValue)
                return searchHelper(nums,mid+1,right-1,target);
            else
                //否则搜索无序区间
                return searchHelper(nums,left,mid-1,target);

        }
    }
    @Test
    public void test(){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int i = searchRange(nums, 0);
        System.out.println(i);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }
}
