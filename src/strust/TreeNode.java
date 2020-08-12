package strust;

public class TreeNode implements Cloneable{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNode addRight(int val){
        TreeNode right=new TreeNode(val);
        this.right=right;
        return right;
    }

    public TreeNode addLeft(int val){
        TreeNode left=new TreeNode(val);
        this.left=left;
        return left;
    }
}
