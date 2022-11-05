package com.liaohui.all.ex_DP.ex_杨辉三角_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2022/1/23 19:50
 */
public class Solution {
    /*public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex).get(rowIndex);
    }*/

        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i <= rowIndex; ++i) {
                row.add(0);
                for (int j = i; j > 0; --j) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }
            return row;
        }



    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  res =  new ArrayList<>();
        if(numRows == 0) return res;
        ArrayList<Integer> tmp1 = new ArrayList<>();
        tmp1.add(0,1);
        ArrayList<Integer> tmp2 = new ArrayList<>();
        tmp2.add(1);
        tmp2.add(1);
        res.add(tmp1);
        if (numRows ==1) return res;
        res.add(tmp2);
        if (numRows == 2) return res;
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(0,1);
            for (int j = 1; j <i ; j++) {
                tmp.add(j,res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            tmp.add(i,1);
            res.add(tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getRow(5));

    }
}
