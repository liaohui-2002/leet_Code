package com.liaohui.all.ex_tree.ex_二叉树深度_104;

/**
 * @auther Mr.Liao
 * @date 2021/8/17 17:44
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
//递归思想
class LinkedBinaryTree
{
    public LinkedBinaryTree(TreeNode root) {
        this.root = root;
    }

    private TreeNode root;
    public int maxDepth(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        else{
//            获取左子树的高度
            int nl = this.maxDepth(root.left);
//            获取右子树的高度
            int nr = this.maxDepth(root.right);
//            大的高度加1
            return nl>nr?nl+1:nr+1;
        }
    }

}

public class Solution {


    public static void main(String[] args) {

        TreeNode node2 = new TreeNode(10,null,null);
        TreeNode node1 = new TreeNode(9,null,node2);
        LinkedBinaryTree btree = new LinkedBinaryTree(node1);
        System.out.println(btree.maxDepth(node1));
    }
}
