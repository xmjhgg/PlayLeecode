package strust;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node(int x) { val = x; }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

    public Node addRight(int val){
        Node right=new Node(val);
        this.right=right;
        return right;
    }

    public Node addLeft(int val){
        Node left=new Node(val);
        this.left=left;
        return left;
    }
}
