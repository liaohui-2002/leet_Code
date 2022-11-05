package com.liaohui.all.ex_DFS.ex_路径总和二_113;


import java.util.ArrayList;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2021/9/16 20:18
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //corner case
        if(root == null)
        {
            return res;
        }
        helper(root, targetSum);
        return res;
    }
    public void helper(TreeNode root,int targetSum)
    {
        if(root == null)return;
        targetSum = targetSum-root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0 ) {
            res.add(new ArrayList<>(list));
        }

        helper(root.left,targetSum);
        helper(root.right,targetSum);
        list.remove(list.size()-1);
    }
}
