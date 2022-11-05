package com.liaohui.all.ex_recursion.ex_2的幂次方_231;

/**
 * @auther Mr.Liao
 * @date 2021/9/25 21:37
 */
/*递归解决
* */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n>0)
        {
            if(n == 1)
            {
                return true;
            }
            if(n%2 != 0)
            {
                return  false;
            }
            return isPowerOfTwo(n/2);
        }
        return false;
    }
}
