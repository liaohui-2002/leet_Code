package com.liaohui.all.ex_Backtrack.ex_77_组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.lh
 * @date 2022/11/16 20:41
 */

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class Solution {
    //结果集
    List<List<Integer>> res = new ArrayList<>();
    //暂存容器
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return res;
    }

    private void backtracking(int n, int k, int startIndex) {
        //终止条件
        if(tmp.size() == k){
            //终止的操作是把临时容器中中的内容收集
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = startIndex; i <=n ; i++) {
            tmp.add(i);
            backtracking(n,k,i+1);
            //回溯法最重要的一步  撤销
            tmp.remove(tmp.size()-1);
        }
    }
}
