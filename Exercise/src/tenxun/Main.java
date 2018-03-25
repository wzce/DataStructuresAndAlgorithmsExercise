package tenxun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zuce wei on 2018/3/23.
 */


class Vector{
    int x;
    int y;
    public Vector(Point p1,Point p2){
        this.x=p2.x-p1.x;
        this.y=p2.y-p1.y;
    }

    public boolean isReact(Vector v){
        return 0==(this.x*v.x+this.y*v.y);
    }
}


class Point{
    int x;
    int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    int len(Point p){
        return ((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));
    }
}

public class Main {

       private static boolean isReact(List<Point> list){
            Point A=list.get(0);
           Point B=list.get(1);
           Point C=list.get(2);
           Point D=list.get(3);
           Vector AB= new Vector(A,B);
           Vector AD=new Vector(A,D);
           if(AB.isReact(new Vector(A,C)) && A.len(B)==A.len(C)
                   && new Vector(A,C).isReact(new Vector(C,D)) && D.len(C)==A.len(C)){//AD与AB垂直
                return true;
           }

           if(new Vector(A,D).isReact(new Vector(C,D)) && A.len(D)==C.len(D)
                   && new Vector(D,C).isReact(new Vector(B,C)) && D.len(C)==C.len(D)){//AD与AB垂直
               return true;
           }

           return false;
       }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int num=in.nextInt();
            int x[]=new int[4];//横坐标
            int y[]=new int[4];//纵坐标

            for(int i=0;i<num;i++){
                List<Point> list=new ArrayList<>();
                for(int k=0;k<4;k++){
                    //输入x轴的坐标
                    x[k]=in.nextInt();
                    Point p=new Point();
                    p.x=x[k];
                    list.add(p);
                }

                for(int k=0;k<4;k++){
                    //输入y轴的坐标
                    y[k]=in.nextInt();
                    list.get(k).setY(y[k]);
                }
                if(Main.isReact(list)){
                    System.out.print("YES");
                }else {
                    System.out.print("NO");
                }

            }

        }
}
