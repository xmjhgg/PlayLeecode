package medium;

import strust.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 例如，给出
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private Map<Integer,Integer> map=new HashMap<>();

    public  TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }


        return getTree(postorder,postorder.length-1,0,postorder.length-1);
    }

    private TreeNode getTree(int[] postOrder,int postRight,int inLeft,int inRight){

        if (inLeft>inRight) return null;
        TreeNode root=new TreeNode(postOrder[postRight]);

        int rootIndex=map.get(postOrder[postRight]);
        int rightTreeSize =inRight-rootIndex;

        root.left=getTree(postOrder,postRight-rightTreeSize-1,inLeft,rootIndex-1);

        root.right=getTree(postOrder,postRight-1,rootIndex+1,inRight);

        return root;
    }

    public static void main(String[] args) {
        int[] preOrder=new int[]{9,3,15,20,7};
        int[] inOrder=new int[]{9,15,7,20,3};

        从中序与后序遍历序列构造二叉树 a=new 从中序与后序遍历序列构造二叉树();

        System.out.println(a.buildTree(preOrder,inOrder));
    }
}
