package alibaba;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * Created by zuce wei on 2018/3/25.
 */
public class CountFutureTask extends RecursiveTask<Long> {
    private static final String baseUrl="";
    private static final int THREAD_HOLD = 5000;
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
//        boolean canCompute = (to - from) <= THREAD_HOLD;
//        if(canCompute){
            for(long i=from;i<=to;i++) {
                String url=baseUrl+date+"/"+i+".htm";
                result=rand.nextInt(9000)+1000;
                if(result%2==0){
                    evenNumbers++;
                }
            }
//        }else {
//            int middle = (from + to) / 2;
//            CountFutureTask left = new CountFutureTask(this.date,from,middle);
//            CountFutureTask right = new CountFutureTask(this.date,middle+1,to);
//            //执行子任务
//            left.fork();
//            right.fork();
//            //获取子任务结果
//            long lResult = left.join();
//            long rResult = right.join();
//            evenNumbers = lResult + rResult;
//        }

        return evenNumbers;
    }

    void cal(){
//        List<CountFutureTask> list=new ArrayList<>(to/THREAD_HOLD+1);
//        int start=0,end=THREAD_HOLD;
//        while (end<to){
//            CountFutureTask task = new CountFutureTask(this.date,start,end);
//            list.add(task);
//            start=end+1;
//            end=end+THREAD_HOLD;
//        }
//        CountFutureTask task = new CountFutureTask(this.date,start,to);
//        list.add(task);
    }
}
