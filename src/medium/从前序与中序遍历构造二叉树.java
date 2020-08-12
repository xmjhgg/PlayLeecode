package medium;

import strust.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历构造二叉树 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */


    /**
     * 题解：
     * 树的前序遍历：根左右
     * 树的中序遍历：左根右
     * 我们要做的就是找出每颗子树的根节点（1个节点的树也是树）
     *
     * 所有我们可以依靠前序遍历，找到每颗子树的根节点，（前序遍历的树第一个节点一定是根节点）
     * 再通过中序遍历的根节点位置确认前序遍历中左子树的长度
     * 又可以通过根节点、前序遍历左子树的长度，得到前序遍历中右子树的长度
     */
    private static Map<Integer, Integer> indexMap;
    public static TreeNode getTree(int[] preOrder,int preLeft,int preRight,int inLeft,int inRight){
        if (preLeft>preRight){
            return null;
        }
        int rootIndex=indexMap.get(preOrder[preLeft]);
        TreeNode root=new TreeNode(preOrder[preLeft]);
        int inLeftSize=rootIndex-inLeft;
        root.left=getTree(preOrder,preLeft+1,preLeft+inLeftSize,inLeft,rootIndex-1);
        root.right=getTree(preOrder,preLeft+inLeftSize+1,preRight,rootIndex+1,inRight);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
       indexMap=new HashMap<>();
       for (int i=0;i<inorder.length;i++){
           indexMap.put(inorder[i],i);
       }

       return getTree(preorder,0,preorder.length-1,0,inorder.length-1);
    }

    public static void main(String[] args) {
        int[] preOrder=new int[]{3,9,20,15,7};
        int[] inOrder=new int[]{9,3,15,20,7};

        System.out.println(buildTree(preOrder,inOrder));
    }



}
