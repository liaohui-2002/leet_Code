package com.liaohui.all.ex_DFS.ex_岛屿数量_200;

/**
 * @auther Mr.Liao
 * @date 2022/1/18 21:14
 */
public class Solution {
    int m,n;
    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int res = 0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j] == '1')
                {
                    res++;
                    dfs(grid,i,j);//扫雷      见到一就把一和周围的一的都变0；
                }

            }
        }
        return res;
    }

    public void dfs(char[][] grid,int i,int j)
    {
        if(i< 0 || j< 0|| i>= m||j>=n|| grid[i][j] == '0') return;//边界或0 直接退出；
        grid[i][j] = '0';
        //探索上下左右
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
