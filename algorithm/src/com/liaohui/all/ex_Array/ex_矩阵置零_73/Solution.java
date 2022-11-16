package com.liaohui.all.ex_Array.ex_矩阵置零_73;

/**
 * @author Mr.lh
 * @date 2022/11/16 19:25
 */

import org.junit.Test;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        //方法一 结束0(m+n)的空间

        //暴力法 注意这里从第二行第二列开始探测
        int m = matrix.length,n=matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] ==0) {
                    //遇到有0的位置把 这一列和这一行的首个元素都置零
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        //根据第一行0的情况将 指定列置零
        for (int i = 0; i < n; i++) {
            if(col[i] == 1){
                for (int j = 0; j <m ; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        //根据第一列的情况将 指定行置零  注意这里第一列可能会被置零
        for (int i = 0; i < m; i++) {
            if(row[i] ==1){
                for (int j = 0; j <n ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void test(){
        int[][] arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(arr);
    }
}
