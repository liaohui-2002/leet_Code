package com.liaohui.all.ex_DFS.ex_单词搜索_79;

/**
 * @auther Mr.Liao
 * @date 2022/1/14 21:35
 */

/*
*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
。
*
*
* */
class Solution {
    int rows, cols;
    char[][] board;
    char[] word;
    //偏移量数组  设置移动方向。
    //int[][] nexts = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;//是否已访问

    public boolean exist(char[][] board, String word) {
        //初始化
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word.toCharArray();
        this.visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean res = search(0, row, col);//0代表从word的首字母开始找
                if (res) return true;
            }
        }
        return false;
    }

    //
    private boolean search(int pos, int row, int col) {
        //边界情况
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return false;
        }
        //不匹配
        if (board[row][col] != word[pos]) {
            return false;
        }
        if (pos == word.length - 1)//已经找到word的最后一个了。
        {
            return true;
        }
        visited[row][col] = true;//标记已经观测过
        //找该字母连续的下一个字母
        boolean res = search(pos + 1, row + 1, col) || search(pos + 1, row, col + 1)
                || search(pos + 1, row - 1, col) || search(pos + 1, row, col - 1);
        visited[row][col] = false;//观测后重置 进入下一轮观测
        return res;
       /* for (int[] next : nexts) {
            //依次找字符串下一个字符
            if (search(pos + 1, row + next[0], col + next[1]))
            {
                return true;
            }
        }*/
        //下一轮观测状态重置


    }

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        Solution s = new Solution();
        boolean res = s.exist(board, word);
        System.out.println(res);
    }
}
