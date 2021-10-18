package program.TreeProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-17
 * @description
 */
public class InvertTree {


    /**
     * invert
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root){

        if (root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {


        TreeNode treeNodeList = TreeNode.getTreeNodeList();

        TreeNode treeNode = invertTree(treeNodeList);

        TreeNode.traverse(treeNode);

    }
}
