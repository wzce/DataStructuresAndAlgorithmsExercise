package alibaba;

import java.util.Random;

/**
 * Created by zuce wei on 2018/3/24.
 */
public class EvenNumbersOfWebPage extends Thread{
    public static final String baseUrl="http://www.domain.com/";
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
