package com.liaohui.all.ex_tree.ex_前序遍历_144;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2021/9/6 20:24
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
//递归遍历
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root,res);
        return res;
    }
    public void preorderTraversal(TreeNode root,List<Integer> res)
    {
        if(root != null) {
            //遍历根结点
            res.add(root.val);
            //遍历左子树
            preorderTraversal(root.left, res);
            //遍历右子树
            preorderTraversal(root.right, res);
        }
    }

    public static void main(String[] args) {
        TreeNode node3 =  new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node3,null);
        TreeNode node1 = new TreeNode(1,null,node2);
        Solution s = new Solution();
        s.preorderTraversal(node1);
        ArrayList<Integer> res = new ArrayList<>();
        s.preorderTraversal(node1,res);
        System.out.println(res);
    }
}
