package niuke;

import java.util.Stack;

/**
 * Created by zuce wei on 2018/3/18.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。对于最小数的获取的时间为)(1)
 */

//使用双栈的思想
public class MInStackO1 {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> min=new Stack<Integer>();
    public void push(int node) {

        if(stack.isEmpty() || node < min.peek()){
            min.push(node);
        }else {
            min.push(min.peek());
        }

        stack.push(node);
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.pop();
    }

    public int min() {
        return min.peek();
    }
}
