package com.liaohui.all.ex_Array.ex_找到所有数组中消失的数字_448;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2022/10/21 23:05
 */

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。`
 *
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int length = nums.length;
        //思路 ： 将数组索引和值一一对应
        for (int num : nums) {
            int index = (num-1)%length;
            nums[index] +=length;
        }

        for (int i = 0; i < length; i++) {
            if(nums[i]<=length){
                res.add(i+1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[]  arr = new int[]{4,3,2,7,8,2,3,1};
        Solution s = new Solution();
        List<Integer> list = s.findDisappearedNumbers(arr);
        System.out.println(list);

    }
}
