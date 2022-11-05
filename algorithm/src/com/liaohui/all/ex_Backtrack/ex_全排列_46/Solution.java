package com.liaohui.all.ex_Backtrack.ex_全排列_46;

import java.util.*;

/**
 * @auther Mr.Liao
 * @date 2022/1/19 18:48
 */
/*
*
*给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。


示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


*
* */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;

    }

    void dfs(int[] nums, List<List<Integer>> res, List<Integer> subset, boolean[] visited) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i!=0&& nums[i] == nums[i-1]&& visited[i-1] == false)) continue;
            subset.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, subset, visited);
            subset.remove(subset.size() - 1);
            visited[i] = false;

        }
    }
}
