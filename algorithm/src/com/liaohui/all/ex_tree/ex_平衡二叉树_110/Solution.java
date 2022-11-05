package com.liaohui.all.ex_tree.ex_平衡二叉树_110;

import com.liaohui.commom.TreeNode;

/**
 * @auther Mr.Liao
 * @date 2021/9/23 22:15
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.right == null&& root.left == null)
        {
            return true;
        }
        //每个结点左右子树高度差都要满足不超过1
        return isBalanced(root.right) && isBalanced(root.left) && Math.abs(getHeight(root.left) - getHeight(root.right))<=1;
    }

    private  int  getHeight(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        else{
//            获取左子树的高度
            int nl = this.getHeight(root.left);
//            获取右子树的高度
            int nr = this.getHeight(root.right);
//            大的高度加1
            return nl>nr?nl+1:nr+1;
        }
    }
}
