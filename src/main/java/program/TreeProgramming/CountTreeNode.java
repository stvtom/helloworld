package program.TreeProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-19
 * @description
 */
public class CountTreeNode {


    public static void main(String[] args) {

        TreeNode treeNodeListRepeat = TreeNode.getTreeNodeListRepeat();

        Integer integer = countTreeNode(treeNodeListRepeat);

        System.err.println(integer);
    }


    public static Integer countTreeNode(TreeNode root){

        if (root == null){
            return 0;
        }

        Integer left = countTreeNode(root.left);

        Integer right = countTreeNode(root.right);

        return left + right + 1;
    }
}
