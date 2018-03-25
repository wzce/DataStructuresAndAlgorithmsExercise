package niuke;

/**
 * Created by zuce wei on 2018/3/17.
 */
public class MoveList {
    public static void reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                for(int k=i;k>=1;k--){
                    if(array[k-1]%2==0){
                        swap(array,k,k-1);
                    }else{
                        break;
                    }
                }
            }
        }
    }

    static void  swap(int array[],int loc1,int loc2){
            int t=array[loc2];
            array[loc2]=array[loc1];
            array[loc1]=t;
    }

    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        MoveList.reOrderArray(a);
       for(int i=0;i<a.length;i++){
           System.out.print(a[i]+"  ");
       }
    }
}
