package simple;

import strust.ListNode;

public class 返回倒数第k个节点 {
    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * 示例：
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     */

    public static int kthToLast(ListNode head, int k) {
        ListNode tempHead=head;
        for (int i=0;i<k;i++){
            tempHead=tempHead.next;
        }

        while (tempHead!=null){
            head=head.next;
            tempHead=tempHead.next;
        }
        return head.val;
    }

    public static int getLength(ListNode node,int len){
        if (node==null){
            return len;
        }
        return getLength(node.next,len+1);
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        root.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        System.out.println(kthToLast(root,2));
    }

}
