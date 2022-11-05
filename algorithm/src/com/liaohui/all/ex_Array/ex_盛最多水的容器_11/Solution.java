package com.liaohui.all.ex_Array.ex_盛最多水的容器_11;



/**
 * @auther Mr.Liao
 * @date 2022/10/14 12:03
 */
public class Solution {
    public int maxArea(int[] height) {

        //思路：双指针
        int result = 0;
        int l = 0,r = height.length-1;
        while(l<r){
            //更新结果  取大值
            result = Math.max(result,Math.min(height[l],height[r])*(r-l));
            //移动隔板
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }
}
