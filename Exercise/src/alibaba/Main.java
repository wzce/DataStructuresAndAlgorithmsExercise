package alibaba;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuce wei on 2018/3/24.
 */
public class Main {
    private static final int THREAD_HOLD = 5000;
    public int statistics(String date,int max,int threadNum){
        int num=0;
        EvenNumbersOfWebPage threadList[]=new EvenNumbersOfWebPage[threadNum];
        int i,from,to;
        for( i=0;i<threadNum-1;i++){
            from =(i-1)*(max/threadNum)+1;
            to =i*(max/threadNum);
            threadList[i]=new EvenNumbersOfWebPage(date,from,to);
        }
        from =(i-1)*(max/threadNum)+1;
        to =(int)Math.ceil(i*((max+0.0)/threadNum));
        threadList[i]=new EvenNumbersOfWebPage(date,from,to);
        for( i=0;i<threadNum;i++){
            threadList[i].start();//依次启动划分的线程任务
        }

        for( i=0;i<threadNum;i++){
            try {
                threadList[i].join();//保证所有爬虫任务结束该线程再进行最后的统计
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for( i=0;i<threadNum;i++){
            num=num+threadList[i].getEvenNumbers();
        }
        return num;
    }

    public static long futrueWay(String date,int to){
//        System.out.println("开始爬虫");
//        CountFutureTask countFutureTask=new CountFutureTask(date,1,max);
//        ForkJoinPool pool = new ForkJoinPool();
        long evenNumbers=0;
        List<CountFutureTask> list=new ArrayList<>(to/THREAD_HOLD+1);
        int start=0,end=THREAD_HOLD;
        while (end<to){
            CountFutureTask task = new CountFutureTask(date,start,end);
            list.add(task);
            start=end+1;
            end=end+THREAD_HOLD;
        }
        CountFutureTask task = new CountFutureTask(date,start,to);
        list.add(task);

        for (CountFutureTask t:list){
            t.fork();
        }

        for (CountFutureTask t:list){
            evenNumbers=t.join()+evenNumbers;
        }

//        Future<Long> result = pool.submit(countFutureTask);
//        pool.shutdown();
//        long res=0;
//        try {
//            res=result.get();
////            System.out.println(res);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        return  evenNumbers;
    }

    public static void main(String args[]){
        Main main=new Main();
//        Timestamp start= new Timestamp(System.currentTimeMillis());
//        System.out.println("统计的结果： "+main.statistics("2018-12-14",100000,50));
        Timestamp end= new Timestamp(System.currentTimeMillis());
//        System.out.print("耗时: " +(end.getTime()-start.getTime()));

        System.out.println("统计的结果： "+main.futrueWay("2018-12-14",100000));
        Timestamp end2= new Timestamp(System.currentTimeMillis());
        System.out.print("耗时: " +(end2.getTime()-end.getTime()));
    }
}
