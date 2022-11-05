package com.liaohui.all.ex_recursion.ex_对称二叉树_101;

import com.liaohui.commom.TreeNode;

/**
 * @auther Mr.Liao
 * @date 2021/9/24 10:46
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
//corner case
        if(root == null|| (root.left == null && root.right == null)){
            return true;
        }
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode l,TreeNode r)
    {
        if(l == null && r == null)
        {
            return true;
        }
        if(l == null||r==null)
        {
            return false;
        }
        return (l.val == r.val) && helper(l.left,r.right)&& helper(l.right,r.left);
    }
}
