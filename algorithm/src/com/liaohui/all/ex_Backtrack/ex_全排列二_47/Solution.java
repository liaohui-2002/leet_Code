package com.liaohui.all.ex_Backtrack.ex_全排列二_47;

import java.util.*;

/**
 * @auther Mr.Liao
 * @date 2022/1/20 19:53
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if(len == 0) return res;

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] visited = new boolean[len];
        Arrays.sort(nums);
        dfs(nums,len,0,path,visited,res);
        return res;
    }

    void dfs(int[] arr,int len,int depth,Deque<Integer> path,
             boolean[] visited,List<List<Integer>> res)
    {
        if(depth == len)
        {
            //res.add(path);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(visited[i]|| (i!= 0 &&arr[i] == arr[i-1] && visited[i-1] == false))
            {
                continue;
            }
            if(!visited[i])
            {
                path.addLast(arr[i]);
                visited[i] = true;

                dfs(arr,len,depth+1,path,visited,res);
                path.removeLast();
                visited[i] = false;
            }

        }
    }
}
