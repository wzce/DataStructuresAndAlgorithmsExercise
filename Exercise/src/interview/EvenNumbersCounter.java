package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * Created by zuce wei on 2018/3/25.
 */
public class EvenNumbersCounter {
    private static final int THREAD_HOLD = 5000;
    public static final String baseUrl="http://www.domain.com/";
    class CountFutureTask extends RecursiveTask<Long> {
        private int from;
        private int to;
        private String date;
        Random rand = new Random();//用于生成随机数
        public CountFutureTask(String date, int from, int to){
            this.date=date;
            this.from=from;
            this.to=to;
        }
        @Override
        protected Long compute() {
            int result;
            long evenNumbers=0;
            for(long i=from;i<=to;i++) {
                String url=baseUrl+date+"/"+i+".htm";
                result=rand.nextInt(9000)+1000;
                if(result%2==0){
                    evenNumbers++;
                }
            }
            return evenNumbers;
        }
    }

    class EvenNumbersOfWebPage extends Thread{
        Random rand = new Random();//用于生成随机数
        private int evenNumbers=0;
        private String date;
        private int from;
        private int to;

        public EvenNumbersOfWebPage(String date,int from,int to){
            this.date=date;
            this.from=from;
            this.to=to;
        }

        @Override
        public void run(){
            int result;
            for(long i=from;i<=to;i++) {
                String url=baseUrl+date+"/"+i+".htm";
                try {
                    //模拟真实环境的去网页上爬虫,假设消耗1s
                    Thread.sleep(10);
//
                    result=rand.nextInt(9000)+1000;
                } catch (InterruptedException e) {
                    result=0;
                    e.printStackTrace();
                }
                if(result%2==0){
                    evenNumbers++;
                }
                // System.out.println("thread name: "+Thread.currentThread().getName()+" sum: "+evenNumbers);
            }
        }
        public int getEvenNumbers() {
            return evenNumbers;
        }
    }

    public int statistics(String date,int max,int threadNum){
        int num=0;
        alibaba.EvenNumbersOfWebPage threadList[]=new alibaba.EvenNumbersOfWebPage[threadNum];
        int i,from,to;
        for( i=0;i<threadNum-1;i++){
            from =(i-1)*(max/threadNum)+1;
            to =i*(max/threadNum);
            threadList[i]=new alibaba.EvenNumbersOfWebPage(date,from,to);
        }
        from =(i-1)*(max/threadNum)+1;
        to =(int)Math.ceil(i*((max+0.0)/threadNum));
        threadList[i]=new alibaba.EvenNumbersOfWebPage(date,from,to);
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

    public static long futureWay(String date,int to){
        long evenNumbers=0;
        List<alibaba.CountFutureTask> list=new ArrayList<>(to/THREAD_HOLD+1);
        int start=0,end=THREAD_HOLD;
        while (end<to){
            alibaba.CountFutureTask task = new alibaba.CountFutureTask(date,start,end);
            list.add(task);
            start=end+1;
            end=end+THREAD_HOLD;
        }
        alibaba.CountFutureTask task = new alibaba.CountFutureTask(date,start,to);
        list.add(task);

        for (alibaba.CountFutureTask t:list){
            t.fork();
        }
        for (alibaba.CountFutureTask t:list){
            evenNumbers=t.join()+evenNumbers;
        }
        return  evenNumbers;
    }

    public static void main(String args[]){

    }
}
