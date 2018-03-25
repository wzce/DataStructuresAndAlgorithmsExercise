package tenxun;

public class Test {

    public static void main(String[] args) {
        Thread cpuThread = new Thread(new Runnable(){       //线程1，去获取cpu利用率
            @Override
            public void run() {
                int i=0;
              while (true){

                  System.out.println("线程1运行中 : "+i);
                  i++;
                  if(i>100){
                      break;
                  }
              }
               System.out.println("1 over---------------------------------------------------------------------");
            }
        });

        Thread memThread = new Thread(new Runnable(){       //线程2，去获取mem利用率
            @Override
            public void run() {
                int i=0;
                while (true){

                    System.out.println("线程2运行中 : "+i);
                    i++;
                    if(i>100){
                        break;
                    }
                }
                System.out.println("2 over---------------------------------------------------------------------");

            }
        });

        Thread netThread = new Thread(new Runnable(){       //线程3，去获取net利用率
            @Override
            public void run() {
                int i=0;
                while (true){

                    System.out.println("线程3运行中 : "+i);
                    i++;
                    if(i>100){
                        break;
                    }
                }
                System.out.println("3 over---------------------------------------------------------------------");
            }
        });


        try {
            cpuThread.start();
            cpuThread.join();
            memThread.start();
            memThread.join();
            netThread.start();


//            memThread.join();
//            netThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("都结束了");

    }
}