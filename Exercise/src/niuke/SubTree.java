package niuke;

import java.util.Stack;

/**
 * Created by zuce wei on 2018/3/17.
 */
public class SubTree {
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root1);
        TreeNode r=null;
        //使用前序遍历先找到值相同的节点
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.val==root2.val){
                r=node;
                break;
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        if(r==null){
            return false;
        }

        if(root2.left==null){//只维持一半的结构相同
            return isSameTree(r.right,root2.right);
        }

        if(root2.right==null){
            return isSameTree(r.left,root2.left);
        }

        return isSameTree(r,root2);
    }

    static boolean  isSameTree(TreeNode base,TreeNode node2){
        if(base==null&&node2==null){
            return true;
        }else if(base==null && node2!=null){
            return false;
        }else if(base!=null && node2==null){
            return true;
        }

        if(base.val!=node2.val){
            return false;
        }
        return isSameTree(base.left,node2.left)&&isSameTree(base.right,node2.right);
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

        TreeNode AA=new TreeNode(1);
        TreeNode BB=new TreeNode(2);
        TreeNode CC=new TreeNode(3);
        AA.left=BB;
        BB.left=CC;
        AA.right=CC;
        CC.left=new TreeNode(6);

        System.out.println(SubTree.HasSubtree(A,AA));
        System.out.println(SubTree.HasSubtree1(A,AA));
    }



    public static boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        if(root2==null) return false;
        if(root1==null && root2!=null) return false;
        boolean flag = false;
        if(root1.val==root2.val){
            flag = isSubTree(root1,root2);
        }
        if(!flag){
            flag = HasSubtree(root1.left, root2);
            if(!flag){
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
