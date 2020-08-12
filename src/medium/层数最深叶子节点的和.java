package medium;

import strust.TreeNode;

public  class 层数最深叶子节点的和 {
    /**
     * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
     */

    public static int deepestLeavesSum(TreeNode root) {
        int depth=getDepth(root,0);
        System.out.println(depth);
        return getSum(root,1,depth);
    }

    public static int getDepth(TreeNode node,int depth){
        if (node!=null){
            return Math.max(getDepth(node.left,depth+1),getDepth(node.right,depth+1));
        }
        return depth;
    }

    public static int getSum(TreeNode node,int currentDepth,int depth){
        if (currentDepth==depth&&node!=null){
            return node.val;
        }else if (node==null){
            return 0;
        }
        return getSum(node.right,currentDepth+1,depth)+getSum(node.left,currentDepth+1,depth);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);

        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.right=node5;
        node5.right=node6;
        node3.left=node7;

        System.out.println(deepestLeavesSum(root));

    }
}
