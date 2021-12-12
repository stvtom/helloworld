package program.TreeProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-17
 * @description
 */
public class Flatten {


    public static void main(String[] args) {

        TreeNode root = TreeNode.getTreeNodeList();
        TreeNode flatten = flatten(root);

        TreeNode.traverse(flatten);

    }


    public static  TreeNode flatten(TreeNode root){

        if (root == null){
            return root;
        }
        flatten(root.left);
        flatten(root.right);
        //后续遍历
        // 1、左右子树已经被拉平成一条链表

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端

        TreeNode p  = root;

        while(p.right != null){
            p = p.right;
        }
        p.right = right;

        return root;
    }

}
