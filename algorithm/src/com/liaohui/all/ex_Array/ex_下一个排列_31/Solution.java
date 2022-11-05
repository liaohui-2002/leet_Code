package com.liaohui.all.ex_Array.ex_下一个排列_31;

/**
 * @auther Mr.Liao
 * @date 2022/10/19 23:03
 */
public class Solution {
    //以1 4 3 2 0为例子
    //2 0 1 3 4
    public void nextPermutation(int[] nums) {
        int size  = nums.length;
        //corner case
        if (size<=1) {
            return;
        }
        //思路
       int i = size-2;

        //找到左边靠右的升序位置
        while(i>=0 && nums[i]>=nums[i+1]) i--;

        if(i<0){
            reverse(nums,0,size-1);
        }else {
            //找到仅比目标位置大的数
            int j = size-1;
            while(i<j && nums[j] <= nums[i]) j--;
            swap(nums,i,j);
            reverse(nums,i+1,size-1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}
