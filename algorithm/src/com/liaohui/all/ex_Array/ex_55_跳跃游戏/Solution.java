package com.liaohui.all.ex_Array.ex_55_跳跃游戏;

/**
 * @auther Mr.Liao
 * @date 2022/10/27 21:58
 */

import java.util.ArrayList;

/**
 * 贪心
 */
public class Solution {
    public boolean canJump(int[] nums) {
        //注意i+nums[i]  贪心  选择能跳最远
        ArrayList<Integer> jump = new ArrayList<>();//保存每个位置可以到达最远距离的index
        for (int i = 0; i <nums.length ; i++) {
            jump.add(i+nums[i]);
        }
        int index=  0;//存储当前所在位置 初始化为0
        int max_jump = jump.get(0);//存储当前可以到达的最远位置
        while(index<nums.length && index <=max_jump)
        {
            if(max_jump<jump.get(index)){
                max_jump = jump.get(index);
            }
            index++;
        }
        if(index == nums.length) return true;
        return false;

    }
}
