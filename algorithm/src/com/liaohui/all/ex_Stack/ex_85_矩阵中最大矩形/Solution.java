package com.liaohui.all.ex_Stack.ex_85_矩阵中最大矩形;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Mr.lh
 * @date 2022/11/12 18:02
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m  = matrix.length,n = matrix[0].length;
        int []  arr= new int[n];
        int ans = 0;
        //把矩阵按行遍历  逐层转换为柱状图。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if(matrix[i][j] == '1') arr[j]++;
                else arr[j]=0;
            }
            ans = Math.max(ans,largestRectangleArea(arr));
        }
        return ans;
    }

    private  int largestRectangleArea(int[] heights) {
        //corner case
        if (heights.length<=0){
            return 0;
        }
        if(heights.length==1){
            return heights[0];
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        for (int height : heights) {
            tmp.add(height);
        }
        tmp.add(0);

        Stack<Integer> stack = new Stack<>();
        int res=0;
        for (int i = 0; i < tmp.size(); ++i) {
            if(stack.isEmpty() || (tmp.get(i)>=tmp.get(stack.peek()))){
                stack.push(i);
            } else if (tmp.get(i)< tmp.get(stack.peek())) {
                while(!stack.isEmpty() && tmp.get(i)<tmp.get(stack.peek())){
                    int cur_height=tmp.get(stack.peek());
                    stack.pop();
                    int cur_width=i-stack.peek()-1;
                    res=Math.max(res,cur_width*cur_height);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
