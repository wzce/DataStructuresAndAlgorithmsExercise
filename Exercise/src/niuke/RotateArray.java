package niuke;

/**
 * Created by zuce wei on 2018/3/16.
 */
public class RotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        int start=0;
        int end=array.length-1;
        int half=0;
        while(start<end){
            half=(start+end)/2;
            if(array[half+1]>=array[half]){
                //说明在递增段
                if(array[half]>array[end]){
                    start=half;
                }else if(array[start]==array[end]){
                   start++;
                }else {
                    end=half;
                }
            }else{
                break;
            }
        }
        return array[half+1];
    }

    public static void main(String a[]){
        int ar[]={1,0,1,1,1,1};
            System.out.println(RotateArray.minNumberInRotateArray(ar));
    }
}
