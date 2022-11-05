package com.liaohui.all.ex_Array.ex_多数元素_169;

import java.util.Arrays;

/**
 * @auther Mr.Liao
 * @date 2021/9/19 15:06
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

public class Solution {
    /*
    *
    * 方法一 排序法
    * */
    public int majorityElement(int[] nums) {
        //先默认为数组第一个值
        System.out.println();
        Arrays.sort(nums);
        if(nums[0] == nums[nums.length-1])
        {
            return nums[0];
        }
        else
        {
            return nums[nums.length>>>1];
        }

    }
}
