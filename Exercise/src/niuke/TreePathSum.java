package niuke;

import java.util.ArrayList;

/**
 * Created by zuce wei on 2018/3/18.
 */
public class TreePathSum {
    //递归的思路
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root==null){
            return null;
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(root.left==null && root.right==null && root.val==target){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(target);
            res.add(list);
            return res ;
        }

        int remain=target-root.val;
        ArrayList<ArrayList<Integer>> leftList=FindPath(root.left,remain);
        if(leftList!=null){
            res.addAll(leftList);
        }
        ArrayList<ArrayList<Integer>> rightList=FindPath(root.left,remain);
        if(rightList!=null){
            res.addAll(rightList);
        }

        for(ArrayList<Integer> ar:res){
            ar.add(0,root.val);
        }
        return res;
    }

    public static void main(String a[]){
        TreeNode A=new TreeNode(10);
        TreeNode B=new TreeNode(5);
        TreeNode C=new TreeNode(2);
        A.left=B;
        A.right=C;
        TreeNode D=new TreeNode(4);
        TreeNode E=new TreeNode(7);
        B.left=D;
        B.right=E;
//        TreeNode F=new TreeNode(6);
//        C.left=F;
    }
}
