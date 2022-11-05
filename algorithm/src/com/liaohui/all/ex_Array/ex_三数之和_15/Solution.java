package com.liaohui.all.ex_Array.ex_三数之和_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2021/9/6 19:43
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * *  首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，
 *  *  数字分别为 nums[L]和 nums[R]计算三个数的和 sum 判断是否 =0，满足则添加进结果集
 *  *  因为已经排好序了，当 nums[i]大于 0(后面的数都比它大)，则三数之和必然无法等于 0，结束循环
 *  *  如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
 *  *  当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
 *  *  当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
 */
//双指针  难点在于去重
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        //corner case;
        if(nums == null || nums.length<3) return res;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if(i>0 && nums[i-1] == nums[i]) continue; //去重
            int left = i+1;
            int right = nums.length-1;
            while (left<right)
            {
                int sum = nums[i]+nums[left] + nums[right];
                if(sum == 0)
                {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left] == nums [left-1]) left++;//去重
                    while(left<right && nums[right] == nums[right+1]) right--;//去重
                    left++;
                    right--;
                }
                else if(sum>0)
                {
                    right--;
                }
                else{
                    left++;
                }

            }
        }
        return res;
    }
}
