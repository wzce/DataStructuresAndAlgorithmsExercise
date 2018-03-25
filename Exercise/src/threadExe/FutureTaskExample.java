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

        for(int i=from ;i<to;i++){
            Thread.sleep(1000);
            sum=sum+i;
            System.out.println("线程 ："+Thread.currentThread().getName()+"  sum: "+sum);
        }
        System.out.println("线程 ："+Thread.currentThread().getName()+"  结束 ");
        return sum;
    }
}

public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //创建Callable对象任务
        CallableDemo calTask1=new CallableDemo(1,50);
        CallableDemo calTask2=new CallableDemo(51,100);
        CallableDemo calTask3=new CallableDemo(101,150);
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
                System.out.println(" f3 开始阻塞-------------------------------------------------");
                int n1=future3.get();
                System.out.println(" f3 已经阻塞结束-------------------------------------------------");
                System.out.println(" f2 开始阻塞-------------------------------------------------");
                int n2=future2.get();
                System.out.println(" f2 已经阻塞结束-------------------------------------------------");

                System.out.println(" f1 开始阻塞-------------------------------------------------");
                int n3=future.get();
                System.out.println(" f1 已经阻塞结束-------------------------------------------------");
                System.out.println("get 求的和："+((n1+n2+n3)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
//        }
        System.out.println("主线程在执行完成");
    }
}
