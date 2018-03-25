package alibaba;

/**
 * Created by zuce wei on 2018/3/23.
 */

class And extends Thread{
    private long start;
    private long end;
    private long sum=0;
    public And(long start,long end){
        super();
        this.start=start;
        this.end=end;
    }
    public void run(){
        for(long i=start;i<=end;i++) {
            sum += i;
           // System.out.println("thread name: "+Thread.currentThread().getName()+" sum: "+sum);
        }
    }
    public long sum()
    {
        for(long i=start;i<=end;i++)
            sum+=i;
        return sum;
    }
    public long getSum(){
        return sum;
    }
}
public class InternetWorm {
    String url="ewew.ew.ew.--12.html";
    public static void main(String[] args) throws InterruptedException {
        int num=100000000;
        And thread1=new And(1,num);
        And thread2=new And(num+1,2*num);
        And thread3=new And(2*num+1,3*num);
//        And thread4=new And(3*num+1,4*num);
        long startTime=System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
//        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
//        thread4.join();
        long endTime=System.currentTimeMillis();
        System.out.println("并行结果="+(thread1.getSum()+thread2.getSum()+thread3.getSum()));
        System.out.println("并行时间="+(endTime-startTime));

        startTime=System.currentTimeMillis();
        And serial=new And(1,3*num);
        long sum=serial.sum();
        endTime=System.currentTimeMillis();
        System.out.println("串行结果="+sum);
        System.out.println("串行时间="+(endTime-startTime));
       int x= Runtime.getRuntime().availableProcessors();
       System.out.print("内核数：" +x);
    }
}
