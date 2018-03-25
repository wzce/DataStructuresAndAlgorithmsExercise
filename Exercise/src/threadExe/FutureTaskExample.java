package threadExe;

import java.util.concurrent.*;

/**
 * Created by zuce wei on 2018/3/25.
 */

 class CallableDemo implements Callable<Integer> {

    private int sum;
    private int from;
    private int to;
    public CallableDemo(int from,int to){
        this.from=from;
        this.to=to;
    }
    @Override
    public Integer call() throws Exception {

        Thread.sleep(2000);
        for(int i=from ;i<to;i++){
            sum=sum+i;
            System.out.println("线程 ："+Thread.currentThread().getName()+"  sum: "+sum);
        }

        return sum;
    }
}

public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //创建Callable对象任务
        CallableDemo calTask1=new CallableDemo(1,10000);
        CallableDemo calTask2=new CallableDemo(10001,20000);
        CallableDemo calTask3=new CallableDemo(20001,32000);
        //提交任务并获取执行结果
        Future<Integer> future3=es.submit(calTask3);
        Future<Integer> future =es.submit(calTask1);

        Future<Integer> future2 =es.submit(calTask2);

        //关闭线程池,只是不能再继续添加线程了，会等待线程队列都执行完
        es.shutdown();


//        if(){
//        while (!(future.isDone() && future2.isDone())){
//            System.out.println("循环等待完成求和-------------------------------------------");
//            int n1=future.get();
//            System.out.println("已经完成 求的和："+(n1+future2.get()));
//        }
            try {
                int n1=future3.get();
                System.out.println(" f3 已经阻塞-------------------------------------------------");
                System.out.println("get 求的和："+(n1+future.get()+future2.get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
//        }
        System.out.println("主线程在执行完成");
    }
}
