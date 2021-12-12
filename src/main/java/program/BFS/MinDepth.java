package program.BFS;

import program.TreeProgramming.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 *
 * 二叉树最小深度
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485134&idx=1&sn=fd345f8a93dc4444bcc65c57bb46fc35&scene=21#wechat_redirect
 */
public class MinDepth {

    int minDepth(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }
}
