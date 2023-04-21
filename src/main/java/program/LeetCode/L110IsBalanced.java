package program.LeetCode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import program.TreeProgramming.TreeNode;

/**
 * @Author tangkai009
 * @Date 2023-04-21
 * @description
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class L110IsBalanced {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {

        if (root == null){
            return true;
        }

        if (root.right == null && root.left == null){
            return true;
        }

        getDepth(root);

        return result;
    }

    public int getDepth(TreeNode node){

        if (node == null){
            return 0;
        }

        int left = getDepth(node.left);

        int right = getDepth(node.right);

        if (Math.abs(left-right) > 1){

            result = false;
        }

        return 1 + Math.max(left,right);
    }


}
