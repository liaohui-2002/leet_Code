package com.liaohui.all.ex_math.ex_整数除法_29;

/**
 * @auther Mr.Liao
 * @date 2022/10/1 22:44
 */
class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static final int MIN = Integer.MIN_VALUE;

    public int divide(int dividend, int divisor) {
        // 溢出情况
        if (dividend == MIN && divisor == -1) {
            return MAX;
        }

        // 记录结果的符号
        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }

        // 全部转换成负数，防止溢出
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ans = 0;

        // 倍乘法，注意都是负数了，比较的时候与正数相反
        // 简单点理解，就是每次减去除数的 2^x 倍数，剩下的部分继续按这样的规则继续
        while (dividend <= divisor) {
            int tmp = divisor, count = 1;
            // 这里注意不要写成 tmp + tmp >= dividend，这样写加法有可能会溢出导致死循环
            while (tmp >= dividend - tmp) {
                // tmp 和 count 每次增加一倍，所以叫倍增
                tmp += tmp;
                count += count;
            }
            // 被除数减去除数的 2^x 倍数做为新的被除数
            dividend -= tmp;
            // count 即 2^x
            ans += count;
        }

        return sign < 0 ? -ans : ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10,2));
    }

}