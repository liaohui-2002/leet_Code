package com.liaohui.all.ex_tree.ex_后序遍历_145;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @auther Mr.Liao
 * @date 2021/9/6 20:44
 */
class TreeNode {
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
//用栈遍历
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty())
        {
            TreeNode cur = stack.pop();
            list.addFirst(cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return list;
    }
}
