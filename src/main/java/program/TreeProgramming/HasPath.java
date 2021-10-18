package program.TreeProgramming;

/**
 * 二叉树中是否有和为n的路径
 * @Author tangkai009
 * @Date 2021-04-24
 * @description
 */
public class HasPath {

    public static void main(String[] args) {

        Boolean aBoolean = hasPath(TreeNode.getTreeNodeList(), 7);

        System.err.println(aBoolean);
    }

    public static Boolean hasPath(TreeNode root,int n){
        if (root == null ){
            return false;
        }
        n = n - root.val;
        if(n==0&&root.left==null&&root.right==null) {
            return true;
        }
        return hasPath(root.left,n)||hasPath(root.right,n);
    }

}
