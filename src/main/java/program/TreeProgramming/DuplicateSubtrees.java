package program.TreeProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author tangkai009
 * @Date 2021-04-19
 * @description
 */
public class DuplicateSubtrees {



    public static void main(String[] args) {


        TreeNode node = TreeNode.getTreeNodeListRepeat();


        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(node);

        duplicateSubtrees.stream().forEach(e->{
            System.err.println(e.val);
        });

    }


    // 记录所有子树以及出现的次数
    static HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    static LinkedList<TreeNode> res = new LinkedList<>();

    public static  List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }

    public static String traverse(TreeNode root){

        if (root == null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subString = left + "," + right + "," + root.val;

        if (memo.get(subString) != null && memo.get(subString) == 1){
            // 有人和我重复，把自己加入结果列表
            res.add(root);
        }else {
            // 暂时没人跟我重复，把自己加入集合
            Integer count = 0 ;
            if (memo.get(subString) != null){
                count = memo.get(subString);
            }
            memo.put(subString,count + 1);
        }
        return subString;
    }


}
