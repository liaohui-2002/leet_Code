package com.liaohui.all.ex_Array.ex_560_和为K的子数组;

/**
 * @author Mr.lh
 * @date 2022/11/17 16:53
 */

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        //corner case
        if(nums == null || nums.length == 0) return 0;
        //前缀和 表示前缀和总共出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        //
        int res = 0;
        int prefixSum = 0;
        for (int j = 0; j < nums.length; j++) {
            prefixSum += nums[j];
            int diff = prefixSum -k;// diff 指的是prefixSum(j-1)
            res +=map.getOrDefault(diff,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return res;
    }
}
