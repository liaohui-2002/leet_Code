package com.liaohui.all.ex_DP.ex_22_最大括号生成;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.lh
 * @date 2022/11/5 15:37
 */

/**
 * 鉴定为需要重复理解的题
 */
public class Solution {
    //结果数组
    List<String> list = new ArrayList<>();
    int n;
    public   List<String> generateParenthesis(int n) {
        this.n = n;
        hepler("",0,0);
        return list;
    }

    private void hepler(String cur,int left,int right) {
        //跳出条件
        if(left ==n && right ==n){
            list.add(cur);
            return;
        }
        //剪枝
        if(left>n||left<right){
            return;
        }
        hepler(cur+"(",left+1,right);
        hepler(cur+")",left,right+1);
    }
    @Test
    public void test2(){
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
}


