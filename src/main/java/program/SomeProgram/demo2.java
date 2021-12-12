package program.SomeProgram;

import com.google.common.collect.Lists;
import program.TreeProgramming.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangkai009
 * @Date 2021-11-03
 * @description
 */
public class demo2 {
    /**
     * 一颗二叉树
     * 求那一层节点树最多，那一层最多的节点数是多少
     */

     public int getMaxNode(TreeNode node){

         if (node == null){
             return 0;
         }
         if (node.right == null && node.left == null){
             return 1;
         }
         List<TreeNode> nodes = new ArrayList<>();
         nodes.add(node);

         return getMax(nodes,1);
     }


    /**
     * @param nodes 每一层的node
     * @param k 最大值
     * @return
     */
     public int getMax(List<TreeNode> nodes,int k){

         //这一层的最大值
         int size = nodes.size();

         if (size == 0){
             return k;
         }
         List<TreeNode> nodeList = new ArrayList<>();

         for (int i = 0;i< size ;i++){
             if (nodes.get(i).left != null){
                 nodeList.add(nodes.get(i).left);
             }
             if (nodes.get(i).right != null){
                 nodeList.add(nodes.get(i).right);
             }
         }
         int max = nodeList.size() > size ? nodeList.size() : size;

         return getMax(nodeList,max);
     }
}


