package program.LeetCode;

import program.TreeProgramming.TreeNode;

/**
 * @Author tangkai009
 * @Date 2023-04-21
 * @description
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L104MaxDepth {

    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.right),maxDepth(root.left));
    }
}
