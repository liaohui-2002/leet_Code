package com.liaohui.all.ex_Array.ex_128_最长连续序列;

/**
 * @author Mr.lh
 * @date 2022/11/21 10:50
 */

import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        //用一个TreeSet
        int max = 0,count=0,i=0,pre=0;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        //遍历
        for (Integer num : set) {
            if(i==0){
                pre = num;
                count++;i++; max=1;continue;
            }
            if(pre+1 == num){
                count++;
            }else {
                count=1;
            }
            pre = num;
            max = max<count? count:max;
        }
        return max;
    }
}
