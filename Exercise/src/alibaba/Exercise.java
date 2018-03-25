package alibaba;

/**
 * Created by zuce wei on 2018/3/24.
 */
public class Exercise {
    public static void  splitNum(int num,int n){
        int i=1;
        int start,end;
        for(;i<=n-1;i++){
             start =(i-1)*(num/n)+1;
             end =i*(num/n);
            System.out.println("start: "+start+"  end:"+end);
        }
        start =(i-1)*(num/n)+1;
        end =(int)Math.ceil(i*((num+0.0)/n));
        System.out.println("start: "+start+"  end:"+end);
    }
    public static void main(String args[]){
        Exercise.splitNum(13,4);
    }
}
