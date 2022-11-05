package com.liaohui.all.ex_DFS.ex_验证二叉搜索树_98;


import java.util.ArrayList;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2021/9/7 21:09
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 *      ②
 * ①        ③
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 *          ⑤
 * ①             ④
 *         ③           ⑥
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4
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
    List<Integer> list = new ArrayList<>();//建立一个顺序表结构临时储存

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; //空树

        traversal(root);//inorder 中序遍历

        int min = list.get(0);
        for (int i = 0; i < list.size(); i++)
            if (min < list.get(i)) {
                min = list.get(i);
            } else {
                return false;
            }
        return true;
    }

    public void traversal(TreeNode root) {
        if (root != null) {
            traversal(root.left);

            list.add(root.val);

            traversal(root.right);
        }
    }
}
