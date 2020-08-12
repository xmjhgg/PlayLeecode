package simple;

import java.util.Stack;

public class 最小栈 {

    /**
     * 设计一个支持push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     *     push(x) —— 将元素 x 推入栈中。
     *     pop() —— 删除栈顶的元素。
     *     top() —— 获取栈顶元素。
     *     getMin() —— 检索栈中的最小元素。
     *
     *     示例:
     *
     *  输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     *
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    int min=Integer.MAX_VALUE;
    public 最小栈() {
        minStack.push(min);
    }

    public void push(int x) {
        if (minStack.peek()>x){
            minStack.push(x);
        }
        stack.push(x);
    }

    public int pop() {

        minStack.pop();
        return  stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        最小栈 minStack=new 最小栈();
        minStack.push(0);
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(5);
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
