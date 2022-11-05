package com.liaohui.all.ex_tree.ex_SameTree100;

/**
 * @auther Mr.Liao
 * @date 2021/8/14 15:38
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //先比较跟是否相同
        boolean res = isSame(p,q);
        return res;

    }
    boolean isSame(TreeNode p, TreeNode q)
    {
        if( p == null && q ==null)
        {
            return true;
        }
        if( p == null|| q == null)
        {
            return false;
        }
        if(p.val != q.val)
        {
            return false;
        }

            return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
