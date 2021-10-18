package program.TreeProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-15
 * @description
 */
public class TreeNode {

    TreeNode left;

    TreeNode right;

    public TreeNode getRight() {
        return right;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    int val;

    public TreeNode(int val){
        this.val = val;
    }

    public static void main(String[] args) {

        traverse(getTreeNodeList());
    }


    public static void traverse(TreeNode root){

        if (root == null){
            return;
        }
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        System.err.print(root.val);
        traverse(root.right);
        // 后序遍历
    }

    public static TreeNode getTreeNodeList(){

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);


        /**
         *           4
         *         2   7
         *       1  3 6  9
         */
        treeNode4.left = treeNode2 ;treeNode4.right = treeNode7;

        treeNode2.left = treeNode1 ;treeNode2.right = treeNode3;

        treeNode7.left = treeNode6 ;treeNode7.right = treeNode9;

        return treeNode4;
    }


    public static TreeNode getTreeNodeListRepeat(){

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(4);

        treeNode6.left = treeNode9;
        treeNode3.left = treeNode6;treeNode3.right = treeNode7;
        treeNode2.left = treeNode4;
        treeNode1.left = treeNode2; treeNode1.right = treeNode3;
        return treeNode1;
    }
}
