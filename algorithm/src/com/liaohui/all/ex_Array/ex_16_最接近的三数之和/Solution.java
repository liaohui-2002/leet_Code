package com.liaohui.all.ex_Array.ex_16_最接近的三数之和;

import java.util.Arrays;

/**
 * @author Mr.lh
 * @date 2022/11/4 20:44
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //思路 先排序 以nums[i] 为基准，双指针探索 更新与target最接近的三个值之和
        Arrays.sort(nums);
        //遍历基准
        int i=0;
        //迭代更新的将结果
        int result = nums[0]+nums[1]+nums[2];

        for (i = 0;  i< nums.length-2; i++) {
            //定义左右指针
            int left = i+1,right = nums.length-1;
            while(left!=right){
                int sum = nums[i] + nums[left]+nums[right];
                if (Math.abs(sum-target)<Math.abs(result-target)){
                    result =sum;
                }
                if(sum>target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return  result;

    }
}
