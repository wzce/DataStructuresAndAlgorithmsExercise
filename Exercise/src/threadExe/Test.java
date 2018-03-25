package threadExe;

/**
 * Created by zuce wei on 2018/3/21.
 */
public class Test {
    static  int value=0;
    public static void main(String args[]) throws InterruptedException {

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {


                        System.out.println("thread1： " + Thread.currentThread().getName() + "  before add value :" + value);
                        value++;
                        System.out.println("thread1： " + Thread.currentThread().getName() + "  -------- after add value :" + value);
                        if(value>250){
                            break;
                    }
                }
            }
        },"thread1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                        System.out.println("thread2： " + Thread.currentThread().getName() + "  before add value :" + value);
                        value++;
                        System.out.println("thread2： " + Thread.currentThread().getName() + "  -------- after add value :" + value);

                    if(value>150){
                        break;
                    }

                }
            }
        },"thread2");

        t1.start();
        t1.join();
        t2.start();



    }
}
