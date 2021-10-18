package program.TreeProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-19
 * @description
 */
public class InPostBuildTree {


    public static void main(String[] args) {


        int [] inorder = new int[]{9,3,15,20,7};

        int [] postorder = new int[]{9,15,7,20,3};

        TreeNode treeNode = buildTree(inorder, postorder);

        TreeNode.traverse(treeNode);

    }


    public static TreeNode buildTree(int[] inorder, int[] postorder){

        return buildTree(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }



    public static TreeNode buildTree(int[]inorder,int inStart,
                                     int inEnd, int[]postorder,int postStart,int postEnd){

        if (postStart > postEnd || inStart > inEnd){
            return null;
        }
        int treeVal = postorder[postEnd];

        //找中序遍历
        int index = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == treeVal){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;

        TreeNode treeNode = new TreeNode(treeVal);

        treeNode.left = buildTree(inorder,inStart,index-1,postorder,postStart,postStart-1+leftSize);

        treeNode.right = buildTree(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);

        return treeNode;
    }

}
