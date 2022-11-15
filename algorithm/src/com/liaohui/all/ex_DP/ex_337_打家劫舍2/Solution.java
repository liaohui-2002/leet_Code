package com.liaohui.all.ex_DP.ex_337_打家劫舍2;

import com.liaohui.commom.TreeNode;

/**
 * @author Mr.lh
 * @date 2022/11/15 20:37
 */
public class Solution {
    public int rob(TreeNode root) {
        //这里也需要做cornercase判断
        if(root == null) return 0;
        //动态规划  自下而上的维护每个节点的res[2] 值
        // res[1]表示打劫当前节点的收益 res[0] 代表不打劫当前节点的收益‘
       int[] res =  helper(root);
       return Math.max(res[0],res[1]);
    }

    private int[] helper(TreeNode root) {
        int[] res = new int[2];
        if(root == null) return res;
        //遍历左子树
        int[] left = helper(root.left);
        //遍历右子树
        int[] right = helper(root.right);
        //更新当前节点是否选择的res数组
        //不打劫当前结点 结果更新为左子树的最大打劫收益加上右子树的最大打劫收益
        res[0] = 0 + Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //打劫当前节点，要保证左子树右子树都没被打劫
        res[1] = root.val+ left[0]+right[0];
        return res;
    }

   /* @Test
    public void test(){
        TreeNode node1 = new TreeNode()
    }*/
}
