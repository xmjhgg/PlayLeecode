package medium;

import strust.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针II {
    /**
     * 给定一个二叉树
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     *
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL;
     * 初始状态下，所有 next 指针都被设置为 NULL。
     示例1：
     输入：root = [1,2,3,4,5,null,7]
     输出：[1,#,2,3,#,4,5,7,#]
     解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
     */


    /**
     * 思路：使用树的层次遍历，只要当前遍历的节点在同一层中不是第一个，就将上一个节点的next指向当前节点
     */
    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int len = queue.size();

            Node last = null;
            for (int i = 1 ; i<=len ; i++){

                Node current = queue.poll();

                if (current.left!=null){
                    queue.offer(current.left);
                }

                if (current.right != null){
                    queue.offer(current.right);
                }

                if (i!=1){
                    last.next = current;
                }

                last = current;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node2 = root.addLeft(2);
        root.addRight(3).addRight(7);
        node2.addLeft(4);
        node2.addRight(5);

        System.out.println(connect(root));

    }





}
