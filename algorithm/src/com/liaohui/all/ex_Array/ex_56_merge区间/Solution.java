package com.liaohui.all.ex_Array.ex_56_merge区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther Mr.Liao
 * @date 2021/9/19 16:41
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        //cornercase
        if(intervals.length < 2) return intervals;
        //按照各个数组首元素进行一次排序
        Arrays.sort(intervals,new MyComparator());
        int i =1;
        ArrayList<int[]> list = new ArrayList<>();
        //进行区间标记
        int start = intervals[0][0];
        int end = intervals[0][1];
        while(i< intervals.length){
            //标记当前探索到的子数组
            int[] cur = intervals[i];
            if(end<cur[0]){
                //如果当前右边界小于当前探索子数组的左边界 则没有重合
                list.add(new int[]{start,end});
                start = cur[0];
                end = cur[1];
            }else {//发生重合  维护的右边界应更新为
                end = Math.max(end,cur[1]);
            }
            i++;
        }
        list.add(new int[]{start,end});
        int[][] res = new int[list.size()][];
        for (int j = 0; j < list.size() ; j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}

class MyComparator implements Comparator<int[]>{

    @Override
    public int compare(int[] arr1, int[] arr2) {
        return arr1[0]-arr2[0];
    }
}
