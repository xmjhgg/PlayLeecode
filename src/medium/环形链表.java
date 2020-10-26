package medium;

import strust.ListNode;

import java.util.HashSet;
import java.util.List;

public class 环形链表 {
    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false
     */

    public static boolean hasCycle(ListNode head) {

        ListNode currentHead = head;
        HashSet<ListNode> allNode = new HashSet();

        while (currentHead!=null){
            if (!allNode.add(currentHead)){
                return true;
            }else {
                currentHead = currentHead.next;
            }
        }

        return false;

    }

    /**
     * 快慢指针发，当快指针和慢指针重逢的时候，就说明有链表有环型
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if (fast == null || fast.next ==null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        System.out.println(hasCycle2(head));
    }


}
