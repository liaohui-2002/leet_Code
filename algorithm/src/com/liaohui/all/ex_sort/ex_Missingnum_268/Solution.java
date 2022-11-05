package com.liaohui.all.ex_sort.ex_Missingnum_268;

import java.util.Arrays;

/**
 * @auther Mr.Liao
 * @date 2021/10/14 20:59
 */
/*
* 给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
示例 1：
输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
示例 2：
输入：nums = [0,1]
输出：2
解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
*
*
* */
public class Solution {
    public int missingNumber(int[] nums) {

        //corner case
        if(nums.length == 1)
        {
            return nums[0] == 1? 0:1;
        }
        Arrays.sort(nums);

        //处理边界
        if(nums[0] != 0)
        {
            return 0;
        }
        else if(nums[nums.length]!= nums.length)
        {
            return nums.length;
        }
        for (int i = 0; i < nums.length-1; i++) {

            if(nums[i+1]- nums[i] == 2)
            {
                return nums[i] +1;
            }
        }
        return -1;
    }
}
