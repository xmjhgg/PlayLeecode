package simple;

import strust.TreeNode;

public class 找出克隆二叉树中的相同节点 {
    /**
     * 给你两棵二叉树，原始树 original 和克隆树 cloned，
     * 以及一个位于原始树 original 中的目标节点 target。
     * 其中，克隆树 cloned 是原始树 original 的一个副本
     * 请找出在树 cloned 中，与 target 相同 的节点，
     * 并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。

     * 注意：
     * 你不能对两棵二叉树，以及 target 节点进行更改。
     * 只能返回对克隆树 cloned 中已有的节点的引用。
     */


    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original==null){
            return null;
        }
        if (original==target){
//            System.out.println(original.hashCode()+","+target.hashCode()+","+cloned.hashCode());
            return cloned;
        }

        TreeNode ans=getTargetCopy(original.left,cloned.left,target);
        if (ans!=null){
            return ans;
        }
        return getTargetCopy(original.right,cloned.right,target);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        TreeNode clone= (TreeNode) root.clone();
        System.out.println(clone.left.hashCode()+","+root.left.hashCode());

    }
}
