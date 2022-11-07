package com.liaohui.all.ex_Array.ex_旋转图像_48;

import org.junit.Test;

/**
 * @author Mr.lh
 * @date 2022/11/7 23:23
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    @Test
    public void test(){
        int [][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
    }
}
