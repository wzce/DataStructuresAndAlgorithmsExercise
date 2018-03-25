package niuke;

/**
 * Created by zuce wei on 2018/3/16.
 */

public class StructTree {
       //使用递归的方式
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || pre.length==0){
            return null;
        }
        TreeNode node=new TreeNode(pre[0]);
        int loc=0;
        //找到根节点的位置
        for(;loc<in.length;loc++){
            if(in[loc]==pre[0]){
                break;
            }
        }
        int in_left[]=null;
        int in_right[]=null;
        int pre_left[]=null;
        int pre_right[]=null;
        TreeNode left=null;
        TreeNode right=null;
        if(loc!=0){
            in_left=new int[loc];
            for(int i=0;i<loc;i++){
                in_left[i]=in[i];
            }

            pre_left=new int[loc];
            for(int i=1;i<=loc;i++){
                pre_left[i-1]=pre[i];
            }
            left=reConstructBinaryTree(pre_left,in_left);
        }

        if(loc!=in.length){
           in_right =new int[in.length-loc-1];
            for(int i=loc+1;i<pre.length;i++){
                in_right[i-(loc+1)]=in[i];
            }

            pre_right=new int[in.length-loc-1];
            for(int i=loc+1;i<pre.length;i++){
                pre_right[i-loc-1]=pre[i];
            }
            right=reConstructBinaryTree(pre_right,in_right);

        }
        node.left=left;
        node.right=right;
        return node;
    }

    public static void main(String s[]){
        int pre[]={1,2,4,7,3,5,6,8};
        int in[]={4,7,2,1,5,3,8,6};

        System.out.println(StructTree.reConstructBinaryTree(pre,in).left.val);
    }

}
