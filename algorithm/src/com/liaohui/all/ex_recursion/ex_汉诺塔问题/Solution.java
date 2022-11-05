package com.liaohui.all.ex_recursion.ex_汉诺塔问题;

import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2021/9/26 8:58
 */

/*
* 递归思想
* 递归结束条件：只剩下最后一个盘子需要移动
递归函数主功能：
1.首先将 n-1 个盘子，从第一个柱子移动到第二个柱子
2.然后将最后一个盘子移动到第三个柱子上
3.最后将第二个柱子上的 n-1 个盘子，移动到第三个柱子上
函数的等价关系式：
f(n,A,B,C) 表示将n个盘子从A移动到C
f(n,A,B,C)=f(n-1,A,C,B)+f(1,A,B,C)+f(n-1,B,A,C)
* */
public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }
    private void move(int size,List<Integer> from,List<Integer> by,List<Integer> to)
    {
        if(size == 1){
            to.add(from.remove(from.size()-1));
            return;
        }
        //先借助目标柱子将n-1个从起始柱子移动到中间柱子
        move(size-1,from,to,by);
        //把起始柱子最下面的盘子移动到目标柱子
        to.add(from.remove(from.size()-1));
        //再把中间柱子上的n-1个盘子通过起始柱子移动到 目标柱子
        move(size-1,by,from,to);
    }
}
