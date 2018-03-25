package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zuce wei on 2018/3/18.
 * 按层次访问二叉树
 */
public class LevelVisitTree {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }

            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }

    public static void main(String a[]){
        TreeNode A=new TreeNode(1);
        TreeNode B=new TreeNode(2);
        TreeNode C=new TreeNode(3);
        A.left=B;
        A.right=C;
        TreeNode D=new TreeNode(4);
        TreeNode E=new TreeNode(5);
        B.left=D;
        B.right=E;
        TreeNode F=new TreeNode(6);
        C.left=F;
        List<Integer> list=LevelVisitTree.PrintFromTopToBottom(A);
        for(int i:list){
            System.out.print(i+" ");
        }
    }
    
    
}
