package program.LeetCode;

import program.TreeProgramming.TreeNode;

import java.util.*;

/**
 * @Author tangkai009
 * @Date 2023-04-21
 * @description
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class L102LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> resList = new ArrayList<>();

        if (root ==  null){
            return resList;
        }

            // 放入队列
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        // 递归遍历
        levelOrder(resList, queue);

        return resList;
    }

    public static void levelOrder(List<List<Integer>> resList, LinkedList<TreeNode> queue) {

        if (queue.isEmpty()){
            return;
        }

        LinkedList<TreeNode> priorityQueue = new LinkedList<>();

        List<Integer> res  = new ArrayList<>();

        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();


            res.add(node.val);

            if (node.left != null) {
                priorityQueue.offer(node.left);
            }

            if (node.right != null) {
                priorityQueue.offer(node.right);
            }


        }
        resList.add(res);

        levelOrder(resList,priorityQueue);
    }


    public static void main(String[] args) {


        TreeNode treeNodeListRepeat = getTreeNodeListRepeat();

        List<List<Integer>> listList = levelOrder(treeNodeListRepeat);

        System.err.println(listList);
    }

    public static TreeNode getTreeNodeListRepeat(){

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2; treeNode1.right = treeNode3;
        return treeNode1;
    }
}
