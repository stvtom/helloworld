package program.TreeProgramming;

/**
 * 根据前序遍历和中序遍历结果还原二叉树
 * @Author tangkai009
 * @Date 2021-04-17
 * @description
 */
public class PreInBuildTree {


    public static void main(String[] args) {

        int[] preorder = new int[]{3,9,20,15,7};

        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode treeNode = buildTree(preorder, inorder);

        TreeNode.traverse(treeNode);

    }

    /**
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[]preorder,int[]inorder){

        TreeNode treeNode = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

        return treeNode;
    }


    /**
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    public static TreeNode buildTree(int[]preorder,int preStart,
               int preEnd, int[]inorder,int inStart,int inEnd){
        //Mark
        if (preStart > preEnd){
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];

        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        //Mark 偏移量
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preorder,preStart+1,preStart+leftSize,
        inorder,inStart,index-1);

        root.right = buildTree(preorder,preStart+leftSize+1,preEnd,
        inorder,index+1,inEnd);

        return root;
    }

}
