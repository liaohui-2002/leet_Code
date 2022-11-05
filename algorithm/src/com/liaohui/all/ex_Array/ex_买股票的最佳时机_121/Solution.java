package com.liaohui.all.ex_Array.ex_买股票的最佳时机_121;

/**
 * @auther Mr.Liao
 * @date 2022/10/26 11:54
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0],result =0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            result = Math.max(result,prices[i]-min);
        }
        return result;
    }
}
