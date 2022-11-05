package com.liaohui.all.ex_tree.ex_中序遍历94;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2021/8/13 11:01
 */
import java.util.Stack;

//***

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
public class solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        inorderTraversal(res,root);
        return res;
    }
    private void inorderTraversal(List<Integer> res,TreeNode root)
    {
        if(root != null)
        {
            //遍历左子树
            this.inorderTraversal(res,root.left);
            //输出根值
            res.add(root.val);
            //遍历右子树
            this.inorderTraversal(res,root.right);
        }
    }

    public static void main(String[] args) {

        TreeNode node2 = new TreeNode(2,null,null);
        TreeNode node1 = new TreeNode(1,node2,null);
        solution s = new solution();
        s.inorderTraversal(node1);

    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            // 当前节点不为null，入栈，继续往左
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // 当前节点为null，弹出一个，往右
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
