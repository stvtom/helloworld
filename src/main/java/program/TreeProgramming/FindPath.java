package program.TreeProgramming;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树所有路径
 * @Author tangkai009
 * @Date 2021-04-24
 * @description
 */
public class FindPath {


    public static void main(String[] args) {

        TreeNode root = TreeNode.getTreeNodeList();

        List<String> path = findPath(root);

        List<String> pathSumToN = findPathSumToN(root, 7);

        System.err.println(path);

        System.err.println(pathSumToN);

    }

    public static List<String> findPathSumToN(TreeNode root,int sum){

        List<String> pathList = findPath(root);

        List<String> findList = new ArrayList<>();
        for (String path:pathList) {

            String[] split = path.split(",");

            int length = split.length;

            int count  = 0;
            for (int i = 0; i < length; i++) {
                Integer integer = Integer.valueOf(split[i]);

                count = count + integer;
            }

            if (count == sum){
                findList.add(path);
            }
        }
        return findList;
    }


    public static List<String> findPath(TreeNode root){

        if (root == null){
            return null;
        }
        List<String> arrayList = new ArrayList<>();

        findPath(root,"",arrayList);

        return arrayList;
    }

    public static void findPath(TreeNode root, String s, List<String> arrayList) {

        if (root == null){
            return ;
        }
        s = s + root.val;

        if (root.right == null && root.left == null){
            arrayList.add(s);
        }else {
            findPath(root.left,s+",",arrayList);
            findPath(root.right,s+",",arrayList);
        }
    }
}
