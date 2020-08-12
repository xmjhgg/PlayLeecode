package simple;

import java.util.Stack;

public class 用两个栈实现队列 {
    /**
     * 用两个栈实现一个队列。队列的声明如下，
     * 请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(
     * 若队列中没有元素，deleteHead 操作返回 -1 )
     */

    /**
     * 一个入栈，一个出栈
     * 入栈只负责push元素，
     * 出栈当要取队头元素时，如果出栈为空时，将入栈的元素全部pop到栈中
     * 否则pop出栈
     */
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()){
                    return -1;
                }else {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    return stack2.pop();
                }
            } else {
                return stack2.pop();
            }
        }
    }
}
