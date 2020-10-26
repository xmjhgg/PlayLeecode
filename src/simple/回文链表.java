package simple;

import strust.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 回文链表 {
    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     *
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     */

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode currentNode = head;

        List<Integer> list = new ArrayList<>();

        while (currentNode!=null){
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int i = 0;
        int j = list.size()-1;

        while (i<j){
            if (list.get(i).equals(list.get(j))){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2).addNode(2).addNode(1);

        System.out.println(isPalindrome(head));
    }


}
