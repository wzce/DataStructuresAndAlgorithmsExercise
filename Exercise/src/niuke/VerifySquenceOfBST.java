package niuke;

/**
 * Created by zuce wei on 2018/3/18.
 */
public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0){
            return false;
        }
        return isBSTree(sequence,0,sequence.length-1);
    }

    static boolean isBSTree(int [] sequence,int start,int end){
        if(start>=end){
            return true;
        }
        int i=end-1;
        while (i>start && sequence[end]<sequence[i]){
            i--;
        }
        for(int m=start;m<i;m++){
            if(sequence[m]>sequence[end]){
                return false;
            }
        }
        return isBSTree(sequence,start,i) && isBSTree(sequence,i+1,end-1);
    }

    public static void main(String d[]){
        int s[]={2,9,5,16,17,15,19,18,12};
        int ss[]={5,4,3,2,1};
        System.out.print(VerifySquenceOfBST.verifySquenceOfBST(ss));
    }
}
