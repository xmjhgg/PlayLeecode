package simple;

import strust.TreeNode;

public class 二叉搜索树的最近公共祖先 {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:
     * root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     * 示例 1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     * 示例 2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     */

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null|| root.val == p.val || root.val == q.val){
            return root;
        }

        if (p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if (p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = root.addLeft(2);
        node2.addLeft(0);
        TreeNode node4= node2.addRight(4);
        node4.addLeft(3);
        node4.addRight(5);

        TreeNode node8 = root.addRight(8);
        node8.addRight(9);
        node8.addLeft(7);


        System.out.println(lowestCommonAncestor(root,node2,node4).val);
    }

}
