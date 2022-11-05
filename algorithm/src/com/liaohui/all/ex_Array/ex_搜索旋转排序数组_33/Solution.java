package com.liaohui.all.ex_Array.ex_搜索旋转排序数组_33;

/**
 * @auther Mr.Liao
 * @date 2022/10/20 13:24
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //corner case
        int[] arr = new int[2];
        //思路 一次二分找起始点 一次找结束点
        arr[0] = first_position(nums,target);
        arr[1] = last_position(nums,target);
        return arr;
    }
    //探索起始位置
    private  int first_position(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <=right){
            int mid= (left+right)/2;
            if(nums[mid] == target){
                if(mid==0||nums[mid-1]<target){
                    return mid;
                }
                right = mid-1;
            }else  if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        return  -1;//数组中没有目标元素
    }

    //探索结束位置
    private int last_position(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <=right){
            int mid= (left+right)/2;
            if(nums[mid] == target){
                if(mid==nums.length-1||nums[mid+1]>target){
                    return mid;
                }
               left = mid+1;
            }else  if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        return  -1;//数组中没有目标元素
    }
}
