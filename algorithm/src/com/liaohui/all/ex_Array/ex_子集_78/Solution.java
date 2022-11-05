package com.liaohui.all.ex_Array.ex_子集_78;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2022/10/25 13:12
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }
}
