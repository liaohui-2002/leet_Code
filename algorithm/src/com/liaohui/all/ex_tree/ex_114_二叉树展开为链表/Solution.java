package com.liaohui.all.ex_tree.ex_114_二叉树展开为链表;

import com.liaohui.commom.TreeNode;

import java.util.ArrayList;

/**
 * @author Mr.lh
 * @date 2022/11/5 10:49
 */


public class Solution {
    public void flatten(TreeNode root) {
        //思路，前序遍历 展开
        ArrayList<TreeNode> res = new ArrayList<>();
        preorderTraversal(root,res);
        for (int i = 1; i < res.size(); i++) {
            TreeNode pre = res.get(i-1),cur =res.get(i);
            //把pre设为null
            pre.left=null;
            pre.right=cur;
        }
    }

    /**
     * 这里和前序遍历只看1值稍有不同 要把整个节点放进去 修改指针
     * @param root
     * @param res
     */
    private void preorderTraversal(TreeNode root, ArrayList<TreeNode> res) {
        if(root != null){
            res.add(root);

            //遍历左子树、遍历右子树
            preorderTraversal(root.left,res);

            preorderTraversal(root.right,res);
        }
    }
}
