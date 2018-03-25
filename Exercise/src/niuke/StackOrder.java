package niuke;

import java.util.Stack;

/**
 * Created by zuce wei on 2018/3/18.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

//思路：其中的基本思想是：如果它是出栈顺序的话，我可以按照出栈的方式把栈里元素全部出完。
public class StackOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null|| popA==null){
            return false;
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=0,j=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (j<popA.length && stack.peek()==popA[j]){
                j++;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
