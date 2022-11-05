package com.liaohui.all.ex_Array.ex_只出现一次的数字_136;


import org.junit.Test;

/**
 * @auther Mr.Liao
 *
 * @date 2021/9/2 20:14
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int aNum = 0;
        for (int num : nums) {
            aNum ^= num;
        }
        return aNum;
    }

    @Test
    public void Testof_XOR()
    {
        int aNum = 0;
        int[] nums = {4,1,2,1,2};
        for (int num : nums) {
            aNum ^= num;
        }
        System.out.println(aNum);
    }

    @Test
    public void Test2of_XOR()
    {
        int a =  10;
        System.out.println(a^=9);
    }

}
