package com.liaohui.all.ex_DFS.ex_路径总和_112;

/**
 * @auther Mr.Liao
 * @date 2021/9/16 19:41
 *
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
//主要采用递归思想

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //corner case
        if(root == null) return false;
        if(root.left == null && root.right == null ){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val)||
                hasPathSum(root.right,targetSum- root.val);
    }
}
