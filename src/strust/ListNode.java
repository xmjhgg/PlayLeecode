package strust;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public ListNode addNode (int val){
        ListNode node = new ListNode(val);
        this.next = node;
        return node;
    }
}
