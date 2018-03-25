package niuke;

import java.util.Stack;

/**
 * Created by zuce wei on 2018/3/19.
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class SearchTreeToLinkedList {
    public TreeNode Convert(TreeNode root) {
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        TreeNode first,follow;
        TreeNode head=null;
        first=null;
        int index=0;
        do{
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            if(!stack.isEmpty()){
                p=stack.pop();
                if(index==0){
                    first=p;
                    head=first;//第一次，获取第一个元素的时候
                }else {
                    follow=p;
                    first.right=follow;
                    follow.left=first;
                    first=first.right;
                }
                //visit p;
                p=p.right;
                index++;
            }
        }while (!stack.isEmpty() || p!=null);
        return head;
    }
}
