package com.liaohui.all.ex_Array.ex_接雨水_42;

/**
 * @auther Mr.Liao
 * @date 2022/10/20 12:54
 */
public class Solution {
    public int trap(int[] height) {
        //corner case
        if (height.length<=1) {
            return 0;
        }
        int result = 0;//结果
        int maxValue = -1;//最大值
        int maxIndex=0;//最大值的索引
        //获取最大值 及其索引位置
        for (int i = 0; i <height.length ; i++) {
            if(height[i]>maxValue){
                maxValue = height[i];
                maxIndex = i;
            }
        }
        //处理最大值左边的部分
        int left=0;
            for (int i = left+1; i <=maxIndex; i++) {
                if(height[i]<height[left]){
                    result=result+(height[left]-height[i]);
                }else {
                    left = i;
                }
            }
        //处理最大值右边部分
        int right = height.length-1;
        for (int i = right-1; i >=maxIndex ; i--) {
            if(height[i] < height[right]){
                result = result +(height[right]-height[i]);
            }else {
                right =  i;
            }

        }
        return result;
    }
}
