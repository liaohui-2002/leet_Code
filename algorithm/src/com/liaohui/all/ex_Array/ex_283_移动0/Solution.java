package com.liaohui.all.ex_Array.ex_283_移动0;

/**
 * @author Mr.lh
 * @date 2022/11/15 19:56
 */

import org.junit.Test;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 */
public class Solution {
    public void  moveZeroes(int[] nums) {
        //思路 快慢指针
        //cornercase
        if(nums.length==0) return;
        int fast =0,slow=0;
        while(fast<nums.length){
            if(nums[fast] == 0) fast++;
            else {
                //遇到不是0的就给慢指针赋值
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        for (int i = slow; i <nums.length ; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{0,1,0,3,12};
//        int[] zeroes = moveZeroes(nums);
//        System.out.println(Arrays.toString(zeroes));
    }
}
