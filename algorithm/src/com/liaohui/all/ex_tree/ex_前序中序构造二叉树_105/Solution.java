package com.liaohui.all.ex_tree.ex_前序中序构造二叉树_105;

import com.liaohui.commom.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.lh
 * @date 2022/11/8 16:56
 */
public class Solution {
    //借助一个索引表，辅助定位
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap  = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //这里用结点的值作为key，把数列中节点的index作为Value 因为后面要获取的就是节点的index
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点 记录index 后续使用
        int preorder_root = preorder_left;
        // 找到中序遍历中根节点的index
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 建立根结点
        TreeNode root  = new TreeNode(inorder[inorder_root]);
        // 得到左子树中的节点数目 中间量 用于构造递归
        int left_subtree_size = inorder_root-inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+left_subtree_size,inorder_left,inorder_root-1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder,inorder,preorder_left+left_subtree_size+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
}
