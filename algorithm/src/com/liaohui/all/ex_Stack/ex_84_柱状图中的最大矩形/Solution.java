package com.liaohui.all.ex_Stack.ex_84_柱状图中的最大矩形;

import org.junit.Test;

import java.util.*;


/**
 * @author Mr.lh
 * @date 2022/11/4 22:19
 */

/**
 * 没写注释。
 */
public class Solution {
    public  int largestRectangleArea(int[] heights) {
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

    @Test
    public void test(){
        int[] arr = new int[]{2,1,5,6,2,3};
        int area = largestRectangleArea(arr);
        System.out.println(area);
    }
}
