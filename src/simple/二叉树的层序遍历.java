package simple;

import strust.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class 二叉树的层序遍历 {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
     * （即逐层地，从左到右访问所有节点）。
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        List<TreeNode> helperList=new LinkedList<>();
        helperList.add(root);
        while (helperList.size()>0){
            int size=helperList.size();
            List<Integer> list=new ArrayList<>();

            while (size>0){

                System.out.println(helperList);
                TreeNode node=helperList.remove(0);

                list.add(node.val);

                size--;
                if (node.left!=null){
                    helperList.add(node.left);
                }
                if (node.right!=null)
                    helperList.add(node.right);

            }

            ans.add(list);
        }

        return ans;
    }
    public static Integer getTreeLen(TreeNode treeNode){
        if (treeNode==null) return 0;
        int leftHeight=getTreeLen(treeNode.left);
        int righHeight=getTreeLen(treeNode.right);

        return leftHeight>righHeight?leftHeight+1:righHeight+1;


    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        System.out.println(levelOrder(root));
    }
}
