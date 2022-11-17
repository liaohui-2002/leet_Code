package com.liaohui.all.ex_Array.ex_最小两个连续子数组长度和_柠檬微趣;

/**
 * @author Mr.lh
 * @date 2022/11/17 16:03
 */

/**
 * 最小两个连续子数组长度和
 * 题目
 * 对于给定正整数数组A和给定正整数T，请在A中找出两个连续子数组，这两个子数组不能相交，并且两个子数组的和相等且为T。可能会有多种方案，请返回两个子数组长度和的最小值。如果无法找到这样的方案，返回-1。
 * ————————————————
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * 兼 leetcode 1477
 *
 */
public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
//思路 维护一个dp[n] 表示当前索引及前面的数据能达到目标和的最小长度
        int n = arr.length;
        int[] dp =  new int[n];
        //因为是更新为小值 默认初始化为大值
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        //先把结果初始化为一个大值 遇到小则更新
        int res = Integer.MAX_VALUE;
        //遍历一次 中间进行各种操作
        for(int i=0,j=0,sum=0;j<n;j++){
            sum+=arr[j];
            //处理滑动窗口
            while(i<=j && sum>target){
                sum-= arr[i++];
            }
            //窗口和等于 target ①
            if(sum == target){
                //更新dp
                dp[j] = j-i+1;
                //探索是否已经有满足条件并且不相交的区间 即便dp[i-1] 可以更新最终结果
                if(i>0){
                    res= Math.min(res,dp[i-1]+j-i+1);
                }
            }
            //检测dp[j]是否有可以更新的点
            if(j!=0){
                dp[j] = Math.min(dp[j],dp[j-1]);
            }
        }
        //全部遍历完之后 如果ans还没合理更新 说明没有合适结果
        return res>n? -1:res;
    }

    @Test
    public void test(){
        int[] arr = new int[]{7,3,4,7};
        int i = minSumOfLengths(arr, 7);
        System.out.println(i);
    }
}

/*  暴力 惨遭超时
    List<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> tmp;
    ArrayList<Integer> result = new ArrayList<>();
    public int minSumOfLengths(int[] A, int T) {

        if(A == null || A.length == 0) return -1;
        //用一个map记录符合条件的子数组的起始位置索引和子数组长度
        int size = A.length,sum=0;
        int[] prefixSum = new int[size+1];
        for (int i = 0; i < size; i++) {
            prefixSum[i+1] = prefixSum[i]+A[i];
        }
        //找出所有和为T的子数组
        for (int i = 0; i < size+1; i++) {
            for (int j = i+1; j <size+1 ; j++) {
                if(prefixSum[j]-prefixSum[i] == T){
                    tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j-i);
                    res.add(tmp);
                }
            }
        }
        if(res.size()<2) return -1;
        for (int i = 0; i < res.size(); i++) {
            for (int j = i+1; j < res.size() ; j++) {
                //判断相交
                if(res.get(i).get(0)+res.get(i).get(1)-1 < res.get(j).get(0)){
                    result.add(res.get(i).get(1)+res.get(j).get(1));
                }
            }
        }
        if(result.isEmpty()) return -1;
        Collections.sort(result);
        return result.get(0);

    }*/
