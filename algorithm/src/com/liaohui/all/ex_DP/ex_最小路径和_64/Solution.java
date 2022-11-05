package com.liaohui.all.ex_DP.ex_最小路径和_64;

/**
 * @auther Mr.Liao
 * @date 2022/1/27 17:41
 */
/*给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

 

示例 1：
131
151
421

输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。


*
* */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
        arr[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j!=0)
                {
                    arr[i][j] = arr[i][j-1] + grid[i][j];
                }
                else if(j == 0 && i!=0)
                {
                    arr[i][j] = arr[i-1][j] + grid[i][j];
                }
                else if(i == 0 && j == 0)
                {
                    continue;
                }
                else {
                    int tmp = (arr[i - 1][j] < arr[i][j - 1]) ? arr[i - 1][j] : arr[i][j - 1];
                    arr[i][j] = tmp + grid[i][j];
                }
            }

        }
        return arr[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][]  arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(s.minPathSum(arr));
    }
}
