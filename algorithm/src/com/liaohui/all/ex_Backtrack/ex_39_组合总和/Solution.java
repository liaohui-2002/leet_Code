package com.liaohui.all.ex_Backtrack.ex_39_组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.lh
 * @date 2022/11/6 18:10
 */
public class Solution {
    //结果容器
    List<List<Integer>> res = new ArrayList<>();
    //临时容器
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //迭代器
        helper(candidates,0,target);
        return  res;
    }

    private void helper(int[] candidates, int start, int target) {
        if(target ==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <candidates.length ; i++) {
            if(candidates[i]>target){
                break;
            }
            list.add(candidates[i]);
            helper(candidates,i,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
