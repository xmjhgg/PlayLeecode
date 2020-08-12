package medium;

import strust.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树II {
    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     *
     *
     *
     * 示例：
     *
     * 输入：3
     * 输出：
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     * 0<= n <= 8
     */

    /**
        将一棵树分为左,根,右 三个部分,通过循环,确定每个树的根节点都是不同的树,再通过循环遍历生成的左子树和右子树,获取每种不同的二叉树
     */
    public static List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return getTrees(1,n);
    }

    public static List<TreeNode> getTrees(int start,int end){
        List<TreeNode> allTree= new ArrayList<>();

        //start>end的情况,如果便利的树只有一个节点X了 那么下一次递归左子树的start为X,end为X-1, 右子树的start是X+1,end为X
        //说明这次的树不存在,因此返回空
        if (start>end){
             allTree.add(null);
             return allTree;
        }

        for (int i=start;i<=end;i++){
            List<TreeNode> leftTreenodeList=getTrees(start,i-1);
            List<TreeNode> rightTreenodeList=getTrees(i+1,end);

            for (TreeNode leftNode:leftTreenodeList){
                for (TreeNode rightNode:rightTreenodeList){
                    TreeNode rootNode=new TreeNode(i);
                    rootNode.left=leftNode;
                    rootNode.right=rightNode;
                    allTree.add(rootNode);
                }
            }
        }
        return allTree;

    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3).size());
    }

}
