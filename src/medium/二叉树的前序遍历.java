package medium;

import strust.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历 {

    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     *
     *  示例:
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,2,3]
     */

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        getPreorderTraversal(root,ans);

        return ans;
    }


    /**
     * 递归遍历树时，有一个隐形的栈去记录着指针
     * 而采用迭代的方式去遍历时，就时将这个隐形的栈暴露出来
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        TreeNode node = root;

        while (!stack.isEmpty()||node!=null){

            //优先将左节点压入栈中
            while (node!=null){
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            //左节点为空时，弹出上一个遍历的节点，并将指针指到右节点
            node = stack.pop().right;
        }

        return ans;
    }

    public static void getPreorderTraversal(TreeNode node,List<Integer> ans){
        if (node == null) return;
        ans.add(node.val);
        getPreorderTraversal(node.left,ans);
        getPreorderTraversal(node.right,ans);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.addLeft(2);
        root.addRight(3);

        System.out.println(preorderTraversal2(root));
    }
}
