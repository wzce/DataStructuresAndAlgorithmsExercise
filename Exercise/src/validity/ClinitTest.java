package validity;

/**
 * Created by zuce wei on 2018/3/15.
 */
class Father{
    public static int a = 1;
    static{
        a = 2;
        System.out.println("Father static block");
    }

    public Father(){
        a=3;
        System.out.println("Father create function.");
    }
}

class Child extends Father{
    public static int b = a;
    static{
        a = 3;
        System.out.println("Child static block");
    }

    public Child(){
        a=3;
        System.out.println("Child create function.");
    }
}

public class ClinitTest{
    public static void main(String[] args){
        System.out.println(Child.a);
        System.out.println("----------");
//        Child child=new Child();
//        System.out.println(Child.a);
    }
}