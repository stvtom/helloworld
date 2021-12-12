package program.TreeProgramming;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @Author tangkai009
 * @Date 2021-04-24
 * @description
 */
public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null){
            return null;
        }
        if (root == p){
            return p;
        }
        if (root == q){
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);


        if (left !=null && right!=null){
            return root;
        }

        if (left !=null){
            return left;
        }

        if (right !=null){
            return right;
        }

        return null;
    }
}
