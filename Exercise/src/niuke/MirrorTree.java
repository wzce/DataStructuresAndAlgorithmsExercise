package niuke;

import java.util.Stack;

/**
 * Created by zuce wei on 2018/3/17.
 *
 * 二叉树的镜像定义：源二叉树
    8
  /  \
 6   10
 / \  / \
 5  7 9 11
 镜像二叉树
   8
 /  \
 10   6
 / \  / \
 11 9 7  5
 */
public class MirrorTree {
    //使用递归的方式
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode left=root.left;
        root.left=root.right;
        root.right=left;

        Mirror(root.left);
        Mirror(root.right);
    }

    public void morrir(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            TreeNode left=node.left;
            node.left=node.right;
            node.right=left;
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }
}
