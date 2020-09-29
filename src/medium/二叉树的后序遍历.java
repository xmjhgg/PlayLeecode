package medium;

import strust.TreeNode;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

public class 二叉树的后序遍历 {
    /**
     * 给定一个二叉树，返回它的 后序 遍历。
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [3,2,1]
     *
     */


    public static List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        getAnswer(root.left,ans);
        getAnswer(root.right,ans);
        ans.add(root.val);

        return ans;
    }

    public static void getAnswer(TreeNode node,List<Integer> ans){

        if (node == null) return;

        getAnswer(node.left,ans);
        getAnswer(node.right,ans);
        ans.add(node.val);


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.addRight(2).addLeft(3);
        System.out.println(postorderTraversal(root));
    }

}
